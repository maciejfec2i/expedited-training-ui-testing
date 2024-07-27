package com.saucedemo.stepdefinitions;

import com.saucedemo.actor.questions.LoginCredentials;
import com.saucedemo.actor.tasks.Login;
import com.saucedemo.data.Credentials;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;

public class ActSteps {

    /**
     * Act step for an attempt to log in to the Swag Labs Site. It should be noted that the {@link Login} task, does not
     * open the Login page, this should be set up via the {@link ArrangeSteps#givenActorWasAbleToOpenTheBrowserOnThePage(Actor, PageObject)}
     * Arrange step.
     *
     * @param actor {@link Actor} instance injected by the {@link ParameterDefinitions#actor(String)} parameter definition.
     */
    @When("{actor} attempt(s) to log in to the site")
    public void whenActorAttemptsToLogInToTheSite(Actor actor) {
        Credentials credentials = actor.asksFor(LoginCredentials.of(actor));
        actor.attemptsTo(Login.using(credentials));
    }
}
