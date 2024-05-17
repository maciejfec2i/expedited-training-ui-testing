package com.expeditedtraining.uitesting.user.interactions.silent;

import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Drag;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * The purpose of this class is to silently (without reporting) drag and drop the provided draggable {@link Target}
 * instance element on the provided {@link Target} instance element after waiting for both to be visible and clickable.
 *
 * @author Maciej Fec
 * @version 14/05/2024
 */
public class SilentlyDragAndDropTargetOnTarget implements Performable, IsSilent {

    private final Target draggableTarget;
    private final Target target;

    public SilentlyDragAndDropTargetOnTarget(Target draggableTarget, Target target) {
        this.draggableTarget = draggableTarget;
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(draggableTarget, isVisible()),
                WaitUntil.the(draggableTarget, isClickable()),
                WaitUntil.the(target, isVisible()),
                WaitUntil.the(target, isClickable()),
                Drag.from(draggableTarget).to(target)
        );
    }
}
