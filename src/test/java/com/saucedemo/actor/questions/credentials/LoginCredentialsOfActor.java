package com.saucedemo.actor.questions.credentials;

import com.saucedemo.data.Credentials;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LoginCredentialsOfActor implements Question<Credentials> {

    private final Actor targetActor;

    public LoginCredentialsOfActor(Actor targetActor) {
        this.targetActor = targetActor;
    }

    @Override
    public Credentials answeredBy(Actor actor) {
        return Credentials.valueOf(targetActor.getName().toUpperCase().replace(" ", "_"));
    }
}
