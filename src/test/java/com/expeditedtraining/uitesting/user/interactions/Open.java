package com.expeditedtraining.uitesting.user.interactions;

import com.expeditedtraining.uitesting.user.interactions.silent.SilentlyOpenPage;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

/**
 * The purpose of this class is to act as something of a factory for {@link Performable} tasks related to opening the
 * browser on a specified target.<br><br>
 *
 * New methods can be added as required.
 *
 * @author Maciej Fec
 * @version 08/05/2024
 */
public class Open {

    /**
     * Takes in an object that is an instance of the {@link PageObject} class annotated with the {@link net.serenitybdd.annotations.DefaultUrl}
     * annotation. The annotation value needs to be set to the property name under which the url is stored within
     * the environment section of the serenity.conf file.
     *
     * @param targetPage Object that is an instance of the {@link PageObject} class.
     * @return A {@link Task} based on the {@link SilentlyOpenPage} {@link Performable} interaction.
     *
     * @author Maciej Fec
     * @version 08/05/2024
     */
    public static Performable the(PageObject targetPage) {
        return Task.where(
                "{0} opens the browser on " + targetPage,
                Tasks.instrumented(SilentlyOpenPage.class, targetPage)
        );
    }
}
