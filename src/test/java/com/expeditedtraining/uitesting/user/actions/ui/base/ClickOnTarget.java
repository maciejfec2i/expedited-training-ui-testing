package com.expeditedtraining.uitesting.user.actions.ui.base;

import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ClickOnTarget implements Performable, IsHidden {

    private Target target;

    public ClickOnTarget(Target target) {
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
