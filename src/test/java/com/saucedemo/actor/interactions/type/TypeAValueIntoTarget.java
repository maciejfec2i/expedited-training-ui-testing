package com.saucedemo.actor.interactions.type;

import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.saucedemo.utils.Timeouts.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class TypeAValueIntoTarget implements Performable, IsHidden {

    private final Logger LOGGER = LoggerFactory.getLogger(TypeAValueIntoTarget.class);

    private final String value;
    private final Target targetElement;

    public TypeAValueIntoTarget(String value, Target targetElement) {
        this.value = value;
        this.targetElement = targetElement;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} attempts to type the value '{}' into the {}", actor.getName(), value, targetElement);

        actor.attemptsTo(
                WaitUntil.the(targetElement, isVisible()).forNoMoreThan(specifiedElementVisibleTimeout()),
                WaitUntil.the(targetElement, isClickable()).forNoMoreThan(specifiedElementClickableTimeout()),
                Enter.theValue(value).into(targetElement)
        );
    }
}

