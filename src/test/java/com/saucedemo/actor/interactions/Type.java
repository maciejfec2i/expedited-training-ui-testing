package com.saucedemo.actor.interactions;

import com.saucedemo.actor.interactions.type.TypeAValueIntoTarget;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

/**
 * The purpose of this class is to act as something of a factory for {@link Performable} tasks related to typing
 * a specified value into an element located by the strategy of choice.<br><br>
 *
 * New methods can be added as required.
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
     * @return A {@link Task} based on the {@link TypeAValueIntoTarget} {@link Performable} interaction.
     */
    public Performable into(Target target) {
        return Tasks.instrumented(TypeAValueIntoTarget.class, value, target);
    }
}
