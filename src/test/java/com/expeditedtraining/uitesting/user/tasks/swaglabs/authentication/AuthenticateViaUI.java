package com.expeditedtraining.uitesting.user.tasks.swaglabs.authentication;

import com.expeditedtraining.uitesting.user.credentials.Credentials;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;

public class AuthenticateViaUI implements Performable, IsHidden {

    private final Credentials credentials;

    public AuthenticateViaUI(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
    }
}
