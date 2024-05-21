package com.expeditedtraining.uitesting.user.tasks.swaglabs.authentication;

import com.expeditedtraining.uitesting.user.credentials.Credentials;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthenticateViaUI implements Performable, IsHidden {

    private final Logger LOGGER = LoggerFactory.getLogger(AuthenticateViaUI.class);

    private final Credentials credentials;

    public AuthenticateViaUI(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} attempts to authenticate as {} using the ui", actor.getName(), credentials);

        //TODO: implement logic to login via the UI
    }
}
