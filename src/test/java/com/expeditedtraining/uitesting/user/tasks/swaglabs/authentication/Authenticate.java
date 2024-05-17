package com.expeditedtraining.uitesting.user.tasks.swaglabs.authentication;

import com.expeditedtraining.uitesting.user.credentials.Credentials;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Authenticate {

    private Class<? extends Performable> authenticationTask;

    public Authenticate( Class<? extends Performable> authenticationTask) {
        this.authenticationTask = authenticationTask;
    }

    public static Authenticate viaTheUI() {
        return new Authenticate(AuthenticateViaUI.class);
    }

    public static Authenticate viaTheAPI() {
        return new Authenticate(AuthenticateViaAPI.class);
    }

    public Performable with(Credentials credentials) {
        return Task.where(
                "{0} sign(s) in to the system",
                Tasks.instrumented(authenticationTask, credentials)
        );
    }
}
