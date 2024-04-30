package com.expeditedtraining.uitesting.stepdefinitions;

import com.expeditedtraining.uitesting.user.actions.browser.OpenBrowser;
import com.expeditedtraining.uitesting.user.actions.ui.TriggerJSPrompt;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;

public class ArrangeSteps {

    @Given("the {user} is on the {string} page")
    public void userIsOnTheInitialPage(Actor user, String pageName) {
        user.attemptsTo(
                OpenBrowser.on(pageName)
        );
    }

    @Given("{user} have triggered a {string}")
    public void userHasTriggeredAJSPrompt(Actor user, String promptType) {
        user.attemptsTo(
                TriggerJSPrompt.ofType(promptType)
        );
    }
}
