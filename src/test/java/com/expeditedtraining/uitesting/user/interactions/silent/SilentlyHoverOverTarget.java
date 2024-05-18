package com.expeditedtraining.uitesting.user.interactions.silent;

import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.HoverOverTarget;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * The purpose of this class is to silently (without reporting) hover over the provided {@link Target}
 * instance element after waiting for the target to be visible and clickable.
 *
 * @author Maciej Fec
 * @version 14/05/2024
 */
public class SilentlyHoverOverTarget implements Performable, IsSilent {

    private final Logger LOGGER = LoggerFactory.getLogger(SilentlyHoverOverTarget.class);

    private final Target target;

    public SilentlyHoverOverTarget(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} attempts to hover over the {}", actor.getName(), target);

        actor.attemptsTo(
                WaitUntil.the(target, isVisible()),
                WaitUntil.the(target, isClickable()),
                HoverOverTarget.over(target)
        );
    }
}
