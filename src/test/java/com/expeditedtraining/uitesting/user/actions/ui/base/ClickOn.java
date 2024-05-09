package com.expeditedtraining.uitesting.user.actions.ui.base;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ClickOn {

    public static ClickOnTarget the(Target target) {
        return Tasks.instrumented(ClickOnTarget.class, target);
    }

    public static ClickOnElement the(WebElementFacade webElement) {
        return Tasks.instrumented(ClickOnElement.class, webElement);
    }
}
