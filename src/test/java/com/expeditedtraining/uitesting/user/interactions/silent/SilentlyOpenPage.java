package com.expeditedtraining.uitesting.user.interactions.silent;

import com.expeditedtraining.uitesting.utils.Environment;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;

/**
 * The purpose of this class is to silently (without reporting) open the browser based on the passed in page object
 * that is an instance of the {@link PageObject} class.<br><br>
 *
 * For this to work, the target page object must be annotated with the {@link DefaultUrl} annotation. The annotation value
 * needs to be set to the property name under which the url is stored within the environment section of the serenity.conf file.
 *
 * @author Maciej Fec
 * @version 08/05/2024
 */
public class SilentlyOpenPage implements Performable, IsSilent {

    private final PageObject targetPage;

    public SilentlyOpenPage(PageObject targetPage) {
        this.targetPage = targetPage;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String annotationValue = targetPage.getClass().getAnnotation(DefaultUrl.class).value();
        String targetUrl = Environment.getEnvironmentSpecificConfiguration().getProperty(annotationValue);

        actor.attemptsTo(Open.url(targetUrl));
    }
}
