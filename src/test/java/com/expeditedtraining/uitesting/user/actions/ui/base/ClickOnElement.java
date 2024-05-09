package com.expeditedtraining.uitesting.user.actions.ui.base;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClickOnElement implements Performable, IsHidden {

    private WebElementFacade webElement;

    public ClickOnElement(WebElementFacade webElement) {
        this.webElement = webElement;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ExpectedConditions.visibilityOf(webElement)),
                WaitUntil.the(ExpectedConditions.elementToBeClickable(webElement)),
                Click.on(webElement)
        );
    }
}
