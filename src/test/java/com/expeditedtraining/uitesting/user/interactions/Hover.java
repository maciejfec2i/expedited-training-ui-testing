package com.expeditedtraining.uitesting.user.interactions;

import com.expeditedtraining.uitesting.user.interactions.silent.SilentlyHoverOverTarget;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class Hover {

    public static Performable over(Target target) {
        return Task.where(
                "{0} hover(s) over the " + target,
                Tasks.instrumented(SilentlyHoverOverTarget.class, target)
        );
    }
}
