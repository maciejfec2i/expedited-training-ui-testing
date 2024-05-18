package com.expeditedtraining.uitesting.user.interactions.silent;

import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * The purpose of this class is to silently (without reporting) double-click on the provided {@link Target}
 * instance element after waiting for the target to be visible and clickable.
 *
 * @author Maciej Fec
 * @version 14/05/2024
 */
public class SilentlyDoubleClickOnTarget implements Performable, IsSilent {

    private final Logger LOGGER = LoggerFactory.getLogger(SilentlyDoubleClickOnTarget.class);

    private final Target target;

    public SilentlyDoubleClickOnTarget(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} attempts to double click on the {}", actor.getName(), target);

        actor.attemptsTo(
                WaitUntil.the(target, isVisible()),
                WaitUntil.the(target, isClickable()),
                DoubleClick.on(target)
        );
    }
}
