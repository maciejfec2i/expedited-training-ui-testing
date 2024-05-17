package com.expeditedtraining.uitesting.stepdefinitions;

import com.expeditedtraining.uitesting.ui.pages.swaglabs.SwagLabsCartPage;
import com.expeditedtraining.uitesting.ui.pages.swaglabs.SwagLabsLoginPage;
import com.expeditedtraining.uitesting.user.credentials.Credentials;
import com.expeditedtraining.uitesting.user.credentials.CredentialsFactory;
import com.expeditedtraining.uitesting.user.tasks.theinternet.TriggerJSPrompt;
import com.expeditedtraining.uitesting.user.interactions.Open;
import com.expeditedtraining.uitesting.user.tasks.swaglabs.authentication.Authenticate;
import com.expeditedtraining.uitesting.user.tasks.swaglabs.cart.AddToCart;
import com.expeditedtraining.uitesting.utils.data.Platform;
import io.cucumber.java.en.Given;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;

import java.util.List;

public class ArrangeSteps {

    private SwagLabsLoginPage swagLabsLoginPage;
    private SwagLabsCartPage swagLabsCartPage;
    private final CredentialsFactory credentialsFactory = new CredentialsFactory();

    @Given("(the ){actor} is/are on the {page} page")
    public void userIsOnTheInitialPage(Actor actor, PageObject targetPage) {
        actor.attemptsTo(Open.the(targetPage));
    }

    @Given("{actor} have triggered a {string}")
    public void userHasTriggeredAJSPrompt(Actor actor, String promptType) {
        actor.attemptsTo(TriggerJSPrompt.ofType(promptType));
    }

    @Given("A {actor} has the following items in the cart: {itemNames}")
    public void userHasTheFollowingItemsInTheCart(Actor actor, List<String> itemNames) {
        Credentials credentials = credentialsFactory.getCredentialsFor(Platform.SWAG_LABS, actor);

        actor.attemptsTo(
                Open.the(swagLabsLoginPage),
                Authenticate.viaTheAPI().with(credentials),
                Open.the(swagLabsCartPage),
                AddToCart.itemsCalled(itemNames)
        );
    }
}
