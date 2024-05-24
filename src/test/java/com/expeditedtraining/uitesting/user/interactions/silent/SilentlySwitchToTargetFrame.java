package com.expeditedtraining.uitesting.user.interactions.silent;

import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The purpose of this class is to silently (without reporting) switch to the provided {@link Target} iframe
 * instance element after waiting for the target to be available to switch to.
 *
 * @author Maciej Fec
 * @version 15/05/2024
 */
public class SilentlySwitchToTargetFrame implements Performable, IsSilent {

    private final Logger LOGGER = LoggerFactory.getLogger(SilentlySwitchToTargetFrame.class);
    private final Target targetFrame;

    public SilentlySwitchToTargetFrame(Target targetFrame) {
        this.targetFrame = targetFrame;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} attempts to switch to the {}", actor.getName(), targetFrame);

        actor.attemptsTo(
                WaitUntil.the(ExpectedConditions.frameToBeAvailableAndSwitchToIt(BrowseTheWeb.as(actor).find(targetFrame)))
        );
    }
}
