package com.expeditedtraining.uitesting.user.interactions;

import com.expeditedtraining.uitesting.user.interactions.silent.SilentlyTypeTheValueIntoTarget;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class ClearThenType {

    private final String value;

    public ClearThenType(String value) {
        this.value = value;
    }

    public static ClearThenType theValue(String value) {
        return new ClearThenType(value);
    }

    /**
     * Takes in an object that is an instance of the {@link Target} class used for locating the element on the page
     * and types the declared value into it.
     *
     * @param target Object that is an instance of the {@link Target} class for locating the element on the page.
     * @return A {@link Task} based on the {@link SilentlyTypeTheValueIntoTarget} {@link Performable} interaction.
     *
     * @author Maciej Fec
     * @version 09/05/2024
     */
    public Performable into(Target target) {
        return Task.where(
                "{0} type(s) '" + value + "' into " + target,
                Tasks.instrumented(SilentlyTypeTheValueIntoTarget.class, value, target)
        );
    }
}
