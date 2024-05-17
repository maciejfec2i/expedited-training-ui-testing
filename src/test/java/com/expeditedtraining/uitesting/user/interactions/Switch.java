package com.expeditedtraining.uitesting.user.interactions;

import com.expeditedtraining.uitesting.user.interactions.silent.SilentlySwitchToDefaultContext;
import com.expeditedtraining.uitesting.user.interactions.silent.SilentlySwitchToBrowserTabByTitle;
import com.expeditedtraining.uitesting.user.interactions.silent.SilentlySwitchToTargetFrame;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class Switch {

    public static Performable toDefaultContext() {
        return Task.where(
                "{0} switch(es) to the default context",
                Tasks.instrumented(SilentlySwitchToDefaultContext.class)
        );
    }

    public static Performable toFrame(Target targetFrame) {
        return Task.where(
                "{0} switch(es) to the " + targetFrame,
                Tasks.instrumented(SilentlySwitchToTargetFrame.class, targetFrame)
        );
    }

    public static Performable toBrowserTabWithTitleOf(String tabTitle) {
        return Task.where(
                "{0} switch(es) to tab with title of " + tabTitle,
                Tasks.instrumented(SilentlySwitchToBrowserTabByTitle.class, tabTitle)
        );
    }
}
