package com.expeditedtraining.uitesting.user.actions.browser;

import com.expeditedtraining.uitesting.utils.urls.Pages;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;

public class OpenBrowser implements Performable, IsHidden {

    private final String pageName;

    public OpenBrowser(String pageName) {
        this.pageName = pageName;
    }

    public static OpenBrowser on(String pageName) {
        return new OpenBrowser(pageName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String pageUrl = Pages.valueOf(this.pageName.toUpperCase().replace(" ", "_")).getPageUrl();
        actor.attemptsTo(
                Open.url(pageUrl)
        );
    }
}
