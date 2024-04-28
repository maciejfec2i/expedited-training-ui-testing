package com.expeditedtraining.uitesting.stepdefinitions;

import com.expeditedtraining.uitesting.user.actions.browser.OpenBrowser;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;

public class ArrangeSteps {

    @Given("the {user} is on the {string} page")
    public void userIsOnTheInitialPage(Actor user, String pageName) throws InterruptedException {
        user.attemptsTo(
                OpenBrowser.on(pageName)
        );

        Thread.sleep(5000);
    }
}
