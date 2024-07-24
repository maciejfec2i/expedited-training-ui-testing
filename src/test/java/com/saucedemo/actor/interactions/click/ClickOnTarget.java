package com.saucedemo.actor.interactions.click;

import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.saucedemo.utils.Timeouts.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ClickOnTarget implements Performable, IsHidden {

    private final Logger LOGGER = LoggerFactory.getLogger(ClickOnTarget.class);

    private final Target targetElement;

    public ClickOnTarget(Target targetElement) {
        this.targetElement = targetElement;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} attempts to click on the {}", actor.getName(), targetElement);

        actor.attemptsTo(
                WaitUntil.the(targetElement, isVisible()).forNoMoreThan(specifiedElementVisibleTimeout()),
                WaitUntil.the(targetElement, isClickable()).forNoMoreThan(specifiedElementClickableTimeout()),
                Click.on(targetElement)
        );
    }
}
