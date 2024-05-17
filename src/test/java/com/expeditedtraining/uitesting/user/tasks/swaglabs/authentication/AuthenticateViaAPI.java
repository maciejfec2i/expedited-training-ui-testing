package com.expeditedtraining.uitesting.user.tasks.swaglabs.authentication;

import com.expeditedtraining.uitesting.user.credentials.Credentials;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Cookie;

public class AuthenticateViaAPI implements Performable, IsHidden {

    private final Credentials credentials;

    public AuthenticateViaAPI(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).getDriver().manage().addCookie(new Cookie("session-username", credentials.getUsername()));
    }
}
