package com.expeditedtraining.uitesting.user.tasks.swaglabs.authentication;

import com.expeditedtraining.uitesting.user.credentials.Credentials;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Cookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthenticateViaAPI implements Performable, IsHidden {

    private final Logger LOGGER = LoggerFactory.getLogger(AuthenticateViaAPI.class);

    private final Credentials credentials;

    public AuthenticateViaAPI(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} attempts to authenticate as {} using the api", actor.getName(), credentials);

        BrowseTheWeb.as(actor).getDriver().manage().addCookie(new Cookie("session-username", credentials.getUsername()));
    }
}
