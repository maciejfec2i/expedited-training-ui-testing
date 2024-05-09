package com.expeditedtraining.uitesting.user.actions.ui;

import com.expeditedtraining.uitesting.user.actions.ui.base.SwitchToTargetFrame;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class SwitchTo {
    public static SwitchToNewWindow aNewWindow() {
        return Tasks.instrumented(SwitchToNewWindow.class);
    }

    public static SwitchToTargetFrame frame(Target targetFrame) {
        return Tasks.instrumented(SwitchToTargetFrame.class, targetFrame);
    }
}
