package com.expeditedtraining.uitesting.stepdefinitions;

import com.expeditedtraining.uitesting.user.actions.browser.OpenBrowser;
import com.expeditedtraining.uitesting.user.actions.ui.TriggerJSPrompt;
import com.expeditedtraining.uitesting.utils.urls.Pages;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;

public class ArrangeSteps {

    @Given("the {actor} is on the {page} page")
    public void userIsOnTheInitialPage(Actor actor, Pages page) {
        actor.attemptsTo(OpenBrowser.on(page));
    }

    @Given("{actor} have triggered a {string}")
    public void userHasTriggeredAJSPrompt(Actor actor, String promptType) {
        actor.attemptsTo(TriggerJSPrompt.ofType(promptType));
    }
}
