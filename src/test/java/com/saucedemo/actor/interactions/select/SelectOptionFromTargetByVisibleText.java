package com.saucedemo.actor.interactions.select;

import com.saucedemo.ui.components.SelectOption;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.saucedemo.utils.Timeouts.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class SelectOptionFromTargetByVisibleText implements Performable {

    private final Logger LOGGER = LoggerFactory.getLogger(SelectOptionFromTargetByVisibleText.class);

    private final String optionText;
    private final Target targetElement;

    public SelectOptionFromTargetByVisibleText(String optionText, Target targetElement) {
        this.optionText = optionText;
        this.targetElement = targetElement;
    }

    @Override
    @Step("{0} selects the option '#optionText' from the #targetElement")
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} attempts to select the option '{}' from the {}", actor.getName(), optionText, targetElement);

        actor.attemptsTo(
                WaitUntil.the(targetElement, isVisible()).forNoMoreThan(specifiedElementVisibleTimeout()),
                WaitUntil.the(targetElement, isClickable()).forNoMoreThan(specifiedElementClickableTimeout())
        );

        WebElementFacade locatedTarget = targetElement.resolveFor(actor);

        locatedTarget
                .findNestedElementsMatching(SelectOption.containingText(optionText))
                .get(0)
                .click();
    }
}
