package com.saucedemo.ui.pages;

import com.saucedemo.utils.Environment;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.model.environment.UndefinedEnvironmentVariableException;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.function.Function;

public class CommonPage extends BasePageObject {

    private final Logger LOGGER = LoggerFactory.getLogger(CommonPage.class);

    private static final Duration GLOBAL_TIMEOUT = Duration.ofSeconds(10);

    private static final Function<String, By> DROPDOWN_OPTION_WITH_VISIBLE_TEXT = visibleText -> By.xpath(
            String.format("//option[contains(normalize-space(), \"%s\")]", visibleText)
    );

    public void openUrl() {
        LOGGER.info("open the browser on the url of the {}", this);

        if(!this.getClass().isAnnotationPresent(DefaultUrl.class)) {
            throw new IllegalArgumentException(this.getClass().getName() + " needs to be annotated with the " + DefaultUrl.class);
        }

        /*
         Check that the defined value for DefaultUrl annotation is present in the serenity.conf environments
         for the environment specified in the Run configuration
         */
        String annotationValue = this.getClass().getAnnotation(DefaultUrl.class).value();
        if(!Environment.environmentSpecificConfigurationHasProperty(annotationValue)) {
            String environment = Environment.getSystemEnvironmentVariables().getProperty("environment");
            throw new UndefinedEnvironmentVariableException(
                    "Variable " + annotationValue + " not found for the '" + environment + "' environment in the serenity.conf file"
            );
        }

        String pageUrl = Environment.getEnvironmentSpecificConfiguration().getProperty(annotationValue);
        openUrl(pageUrl);
    }

    private WebElementFacade waitForElementLocatedBy(By locator) {
        LOGGER.info("with a timeout of {} seconds, wait for element located by {}", GLOBAL_TIMEOUT, locator);

        return withTimeoutOf(GLOBAL_TIMEOUT)
                .waitFor(locator)
                .waitUntilVisible()
                .waitUntilClickable();
    }

    protected void clickOnTheElementLocatedBy(By locator) {
        LOGGER.info("click on element located by {}", locator);

        waitForElementLocatedBy(locator).click();
    }

    protected void enterTextIntoElementLocatedBy(By locator, String textToType) {
        LOGGER.info("type the value '{}' into element located by {}", textToType, locator);

        waitForElementLocatedBy(locator).type(textToType);
    }

    protected void selectFromDropdownLocatedBy(By locator, String optionToSelectText) {
        LOGGER.info("select the option containing text '{}' from element located by {}", optionToSelectText, locator);

        WebElementFacade dropdown = waitForElementLocatedBy(locator);
        dropdown.find(DROPDOWN_OPTION_WITH_VISIBLE_TEXT.apply(optionToSelectText)).click();
    }

    protected String getTextOfElementLocatedBy(By locator) {
        LOGGER.info("get text of the element located by {}", locator);

        return waitForElementLocatedBy(locator).getText();
    }
}