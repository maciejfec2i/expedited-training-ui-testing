package com.expeditedtraining.uitesting.user.interactions;

import com.expeditedtraining.uitesting.user.interactions.silent.SilentlyWithoutClearingTypeTheValueIntoTarget;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class WithoutClearingType {

    private final String value;

    public WithoutClearingType(String value) {
        this.value = value;
    }

    public static Type theValue(String value) {
        return new Type(value);
    }
    public Performable into(Target target) {
        return Task.where(
                "Without clearing {0} type(s) '" + value + "' into " + target,
                Tasks.instrumented(SilentlyWithoutClearingTypeTheValueIntoTarget.class, value, target)
        );
    }
}
