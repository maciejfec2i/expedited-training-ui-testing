package com.expeditedtraining.uitesting.user.interactions;

import com.expeditedtraining.uitesting.user.interactions.silent.SilentlyDoubleClickOnTarget;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

/**
 * The purpose of this class is to act as something of a factory for {@link Performable} tasks related to double-clicking
 * an element located by the strategy of choice.<br><br>
 *
 * New methods can be added as required.
 *
 * @author Maciej Fec
 * @version 14/05/2024
 */
public class DoubleClick {

    /**
     * Takes in an object that is an instance of the {@link Target} class used for locating the element on the page
     * and double-clicks on it.
     *
     * @param target Object that is an instance of the {@link Target} class for locating the element on the page.
     * @return A {@link Task} based on the {@link SilentlyDoubleClickOnTarget} {@link Performable} interaction.
     *
     * @author Maciej Fec
     * @version 14/05/2024
     */
    public static Performable on(Target target) {
        return Task.where(
                "{0} click(s) on " + target,
                Tasks.instrumented(SilentlyDoubleClickOnTarget.class, target)
        );
    }
}
