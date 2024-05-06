package com.expeditedtraining.uitesting.stepdefinitions;

import com.expeditedtraining.uitesting.user.Credentials;
import com.expeditedtraining.uitesting.user.actions.api.Authenticate;
import com.expeditedtraining.uitesting.user.actions.api.UseCartAPI;
import com.expeditedtraining.uitesting.user.actions.browser.OpenBrowser;
import com.expeditedtraining.uitesting.user.actions.ui.TriggerJSPrompt;
import com.expeditedtraining.uitesting.utils.SerenitySessionVariableKeys;
import com.expeditedtraining.uitesting.utils.urls.Pages;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;

import java.util.List;

public class ArrangeSteps {

    @Given("the {actor} is on the {page} page")
    public void userIsOnTheInitialPage(Actor actor, Pages page) {
        actor.attemptsTo(OpenBrowser.on(page));
    }

    @Given("{actor} have triggered a {string}")
    public void userHasTriggeredAJSPrompt(Actor actor, String promptType) {
        actor.attemptsTo(TriggerJSPrompt.ofType(promptType));
    }

    @Given("A {actor} has the following items in the cart: {itemNames}")
    public void userHasTheFollowingItemsInTheCart(Actor actor, List<String> itemNames) {
        Credentials credentials = actor.recall(SerenitySessionVariableKeys.USER_CREDENTIALS);

        actor.attemptsTo(
                OpenBrowser.on(Pages.SWAG_LABS_LOGIN),
                Authenticate.with(credentials),
                OpenBrowser.on(Pages.SWAG_LABS_INVENTORY),
                UseCartAPI.toAddItems(itemNames)
        );
    }

    @Given("{actor} is/are on the {page} page")
    public void userIsOnThePage(Actor actor, Pages page) {
        actor.attemptsTo(OpenBrowser.on(page));
    }
}
