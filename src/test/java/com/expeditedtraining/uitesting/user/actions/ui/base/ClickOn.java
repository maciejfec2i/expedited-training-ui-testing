package com.expeditedtraining.uitesting.user.actions.ui.base;

import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ClickOn implements Performable, IsHidden {

    private Target target;

    public ClickOn(Target target) {
        this.target = target;
    }

    public static ClickOn the(Target target) {
        return new ClickOn(target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(this.target, WebElementStateMatchers.isVisible()),
                WaitUntil.the(this.target, WebElementStateMatchers.isClickable()),
                Click.on(this.target)
        );
    }
}
