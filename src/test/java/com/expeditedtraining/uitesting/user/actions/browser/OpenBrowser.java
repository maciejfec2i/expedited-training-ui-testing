package com.expeditedtraining.uitesting.user.actions.browser;

import com.expeditedtraining.uitesting.utils.urls.Pages;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class OpenBrowser implements Performable, IsHidden {

    private final Pages page;

    public OpenBrowser(Pages page) {
        this.page = page;
    }

    public static OpenBrowser on(Pages page) {
        return Tasks.instrumented(OpenBrowser.class, page);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(page.getPageUrl()));
    }
}
