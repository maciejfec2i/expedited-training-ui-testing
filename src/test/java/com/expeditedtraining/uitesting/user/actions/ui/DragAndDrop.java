package com.expeditedtraining.uitesting.user.actions.ui;

import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class DragAndDrop {

    private final Target fromTarget;

    public DragAndDrop(Target fromTarget) {
        this.fromTarget = fromTarget;
    }

    public static DragAndDrop element(Target fromTarget) {
        return new DragAndDrop(fromTarget);
    }

    public DragAndDropInteraction on(Target toTarget) {
        return new DragAndDropInteraction(fromTarget, toTarget);
    }
}
