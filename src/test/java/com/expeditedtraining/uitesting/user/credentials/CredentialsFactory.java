package com.expeditedtraining.uitesting.user.credentials;

import com.expeditedtraining.uitesting.utils.data.Platform;
import net.serenitybdd.screenplay.Actor;

public class CredentialsFactory {

    public Credentials getCredentialsFor(Platform platform, Actor actor) {
        Credentials credentials;
        String actorName = actor.getName().toUpperCase().replace(" ", "_");

        switch(platform) {
            case SWAG_LABS:
                credentials = SwagLabsCredentials.valueOf(actorName);
                break;
            default: throw new IllegalArgumentException(platform + " is not recognised");
        }

        return credentials;
    }
}
