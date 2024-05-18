package com.expeditedtraining.uitesting.user.interactions.silent;

import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SilentlyWithoutClearingTypeTheValueIntoTarget implements Performable, IsSilent {

    private final Logger LOGGER = LoggerFactory.getLogger(SilentlyWithoutClearingTypeTheValueIntoTarget.class);

    private final String value;
    private final Target target;

    public SilentlyWithoutClearingTypeTheValueIntoTarget(String value, Target target) {
        this.value = value;
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} attempts to type into the {} the value '{}'", actor.getName(), target, value);

        actor.attemptsTo(
                WaitUntil.the(target, isVisible()),
                WaitUntil.the(target, isClickable()),
                Enter.keyValues(value).into(target)
        );
    }
}
