package com.expeditedtraining.uitesting.user.interactions;

import com.expeditedtraining.uitesting.user.interactions.silent.SilentlyClearTheTarget;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class Clear {

    public static Performable the(Target targetField) {
        return Task.where(
                "{0} clear(s) the " + targetField,
                Tasks.instrumented(SilentlyClearTheTarget.class, targetField)
        );
    }
}
