package com.expeditedtraining.uitesting.user.interactions.silent;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * The purpose of this class is to silently (without reporting) click on the provided {@link WebElementFacade} instance element
 * after waiting for the element to be visible and clickable.
 *
 * @author Maciej Fec
 * @version 14/05/2024
 */
public class SilentlyClickOnElement implements Performable, IsSilent {

    private final WebElementFacade element;

    public SilentlyClickOnElement(WebElementFacade element) {
        this.element = element;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ExpectedConditions.visibilityOf(element)),
                WaitUntil.the(ExpectedConditions.elementToBeClickable(element)),
                Click.on(element)
        );
    }
}
