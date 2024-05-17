package com.expeditedtraining.uitesting.user.interactions;

import com.expeditedtraining.uitesting.user.interactions.silent.SilentlyTypeTheValueIntoTarget;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

/**
 * The purpose of this class is to act as something of a factory for {@link Performable} tasks related to typing
 * a specified value into an element located by the strategy of choice.<br><br>
 *
 * New methods can be added as required.
 *
 * @author Maciej Fec
 * @version 09/05/2024
 */
public class Type {

    private final String value;

    public Type(String value) {
        this.value = value;
    }

    public static Type theValue(String value) {
        return new Type(value);
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
