package com.expeditedtraining.uitesting.user.actions.ui;

import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Drag;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class DragAndDropInteraction implements Performable, IsHidden {

    private final Target fromTarget;
    private final Target toTarget;

    public DragAndDropInteraction(Target fromTarget, Target toTarget) {
        this.fromTarget = fromTarget;
        this.toTarget = toTarget;
    }

    @Override
    public <T extends Actor> void performAs(T user) {
        user.attemptsTo(
                WaitUntil.the(fromTarget, WebElementStateMatchers.isVisible()),
                WaitUntil.the(fromTarget, WebElementStateMatchers.isClickable()),
                WaitUntil.the(toTarget, WebElementStateMatchers.isVisible()),
                WaitUntil.the(toTarget, WebElementStateMatchers.isClickable()),
                Drag.from(fromTarget).to(toTarget)
        );
    }
}
