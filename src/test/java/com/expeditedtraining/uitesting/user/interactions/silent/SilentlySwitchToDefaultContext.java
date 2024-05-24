package com.expeditedtraining.uitesting.user.interactions.silent;

import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Switch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The purpose of this class is to silently (without reporting) switch back to the default context after performing
 * actions and/or verifications within a frame or iframe.
 *
 * @author Maciej Fec
 * @version 15/05/2024
 */
public class SilentlySwitchToDefaultContext implements Performable, IsSilent {

    private final Logger LOGGER = LoggerFactory.getLogger(SilentlySwitchToDefaultContext.class);

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} attempts to switch to the default context", actor.getName());

        actor.attemptsTo(
                Switch.toDefaultContext()
        );
    }
}
