package com.expeditedtraining.uitesting.user.actions.ui.base;

import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.HoverOverTarget;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class Hover implements Performable, IsHidden {

    private Target hoverTarget;

    public Hover(Target hoverTarget) {
        this.hoverTarget = hoverTarget;
    }

    public static Hover over(Target target) {
        return Tasks.instrumented(Hover.class, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(hoverTarget, isVisible()),
                WaitUntil.the(hoverTarget, isClickable()),
                HoverOverTarget.over(hoverTarget)
        );
    }
}
