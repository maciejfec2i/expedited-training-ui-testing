package com.expeditedtraining.uitesting.user.interactions;

import com.expeditedtraining.uitesting.user.interactions.silent.SilentlyClickOnElement;
import com.expeditedtraining.uitesting.user.interactions.silent.SilentlyClickOnTarget;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

/**
 * The purpose of this class is to act as something of a factory for {@link Performable} tasks related to clicking
 * an element located by the strategy of choice.<br><br>
 *
 * New methods can be added as required.
 *
 * @author Maciej Fec
 * @version 09/05/2024
 */
public class Click {

    /**
     * Takes in an object that is an instance of the {@link Target} class used for locating the element on the page
     * and clicks on it.
     *
     * @param target Object that is an instance of the {@link Target} class for locating the element on the page.
     * @return A {@link Task} based on the {@link SilentlyClickOnTarget} {@link Performable} interaction.
     *
     * @author Maciej Fec
     * @version 09/05/2024
     */
    public static Performable on(Target target) {
        return Task.where(
                "{0} click(s) on the " + target,
                Tasks.instrumented(SilentlyClickOnTarget.class, target)
        );
    }

    public static Performable on(WebElementFacade element) {
        return Task.where(
                "{0} click(s) on the " + element,
                Tasks.instrumented(SilentlyClickOnElement.class, element)
        );
    }
}
