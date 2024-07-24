package com.saucedemo.actor.interactions;

import com.saucedemo.actor.interactions.click.ClickOnTarget;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

/**
 * The purpose of this class is to act as something of a factory for {@link Performable} tasks related to clicking
 * an element located by the strategy of choice.<br><br>
 *
 * New methods can be added as required.
 */
public class Click {

    /**
     * Takes in an object that is an instance of the {@link Target} class used for locating the element on the page
     * and clicks on it.
     *
     * @param target Object that is an instance of the {@link Target} class for locating the element on the page.
     * @return A {@link Task} based on the {@link ClickOnTarget} {@link Performable} interaction.
     */
    public static Performable on(Target target) {
        return Tasks.instrumented(ClickOnTarget.class, target);
    }
}
