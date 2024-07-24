package com.saucedemo.actor.questions.url;

import com.saucedemo.utils.Environment;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.model.environment.UndefinedEnvironmentVariableException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UrlOfPageObject implements Question<String> {

    private final Logger LOGGER = LoggerFactory.getLogger(UrlOfPageObject.class);

    private final PageObject pageObject;

    public UrlOfPageObject(PageObject pageObject) {
        this.pageObject = pageObject;
    }

    @Override
    public String answeredBy(Actor actor) {
        LOGGER.info("{} asks for the URL of the '{}'", actor.getName(), pageObject.getClass().getSimpleName());

        // Check that target page object has the DefaultUrl annotation
        if(!pageObject.getClass().isAnnotationPresent(DefaultUrl.class)) {
            throw new IllegalArgumentException(pageObject.getClass().getName() + " needs to be annotated with the " + DefaultUrl.class);
        }

        /*
         Check that the defined value for DefaultUrl annotation is present in the serenity.conf environments
         for the environment specified in the Run configuration
         */
        String annotationValue = pageObject.getClass().getAnnotation(DefaultUrl.class).value();
        if(!Environment.environmentSpecificConfigurationHasProperty(annotationValue)) {
            String environment = Environment.getSystemEnvironmentVariables().getProperty("environment");
            throw new UndefinedEnvironmentVariableException(
                    "Variable " + annotationValue + " not found for the '" + environment + "' environment in the serenity.conf file"
            );
        }

        return Environment.getEnvironmentSpecificConfiguration().getProperty(annotationValue);
    }
}
