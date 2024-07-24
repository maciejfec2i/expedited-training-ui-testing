package com.saucedemo.actor.questions;

import com.saucedemo.actor.questions.credentials.LoginCredentialsOfActor;
import com.saucedemo.data.Credentials;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LoginCredentials {

    public static Question<Credentials> of(Actor actor) {
        return Question.about("the login credentials of " + actor.getName()).answeredBy(new LoginCredentialsOfActor(actor));
    }
}
