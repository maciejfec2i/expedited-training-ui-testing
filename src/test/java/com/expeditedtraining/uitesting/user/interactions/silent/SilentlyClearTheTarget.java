package com.expeditedtraining.uitesting.user.interactions.silent;

import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

/**
 * The purpose of this class is to silently (without reporting) clear the provided {@link Target} instance element of
 * any text after waiting for the target to be visible and clickable.
 *
 * @author Maciej Fec
 * @version 18/05/2024
 */
public class SilentlyClearTheTarget implements Performable, IsSilent {

    private final Logger LOGGER = LoggerFactory.getLogger(SilentlyClearTheTarget.class);

    private final Target targetField;

    public SilentlyClearTheTarget(Target targetField) {
        this.targetField = targetField;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} attempts to clear the {}", actor.getName(), targetField);

        actor.attemptsTo(
                WaitUntil.the(targetField, isVisible()),
                WaitUntil.the(targetField, isClickable()),
                Clear.field(targetField),
                WaitUntil.the(targetField, isEmpty())
        );
    }
}
