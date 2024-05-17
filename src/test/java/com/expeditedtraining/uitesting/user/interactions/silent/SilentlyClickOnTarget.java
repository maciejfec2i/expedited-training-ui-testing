package com.expeditedtraining.uitesting.user.interactions.silent;

import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

/**
 * The purpose of this class is to silently (without reporting) click on the provided {@link Target} instance element
 * after waiting for the target to be visible and clickable.
 *
 * @author Maciej Fec
 * @version 09/05/2024
 */
public class SilentlyClickOnTarget implements Performable, IsSilent {

    private final Target target;

    public SilentlyClickOnTarget(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(target, isVisible()),
                WaitUntil.the(target, isClickable()),
                Click.on(target)
        );
    }
}
