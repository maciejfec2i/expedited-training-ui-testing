package com.expeditedtraining.uitesting.user.interactions;

import com.expeditedtraining.uitesting.user.interactions.silent.SilentlyDragAndDropTargetOnTarget;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class DragAndDrop {

    private final Target draggableTarget;

    public DragAndDrop(Target draggableTarget) {
        this.draggableTarget = draggableTarget;
    }

    public static DragAndDrop element(Target draggableTarget) {
        return new DragAndDrop(draggableTarget);
    }

    public Performable on(Target target) {
        return Task.where(
                "{0} drag(s) and drop(s) the " + draggableTarget + " on " + target,
                Tasks.instrumented(SilentlyDragAndDropTargetOnTarget.class, draggableTarget, target)
        );
    }
}
