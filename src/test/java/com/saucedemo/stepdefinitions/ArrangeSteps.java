package com.saucedemo.stepdefinitions;

import com.saucedemo.actor.interactions.Open;
import com.saucedemo.actor.questions.LoginCredentials;
import com.saucedemo.actor.tasks.Authenticate;
import com.saucedemo.actor.tasks.InsertInToTheCart;
import com.saucedemo.data.Credentials;
import com.saucedemo.ui.pages.SwagLabsLoginPage;
import io.cucumber.java.en.Given;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.RememberThat;

import java.util.List;

import static com.saucedemo.data.MemoryKeys.ITEMS_ADDED_TO_CART;

public class ArrangeSteps {

    private SwagLabsLoginPage swagLabsLoginPage;

    /**
     * Arrange step for navigating to a specific page of the Swag Labs Site. To be used to ensure the {@link Actor}
     * is on the page on which Act steps are to be performed.
     *
     * @param actor {@link Actor} instance injected by the {@link ParameterDefinitions#actor(String)} parameter definition.
     * @param page {@link PageObject} instance injected by the {@link ParameterDefinitions#page(String)} parameter definition.
     */
    @Given("(A ){actor} was able to open the {page} page")
    public void givenActorWasAbleToOpenTheBrowserOnThePage(Actor actor, PageObject page) {
        actor.wasAbleTo(Open.the(page));
    }

    /**
     * Arrange step for ensuring the {@link Actor} is logged in and on the expected starting page. Uses the {@link Authenticate}
     * task to login via the backend to ensure no potential {@link SwagLabsLoginPage} UI issues can prevent the
     * testing of other functionalities.
     *
     * @param actor {@link Actor} instance injected by the {@link ParameterDefinitions#actor(String)} parameter definition.
     * @param expectedStartingPage {@link PageObject} instance injected by the {@link ParameterDefinitions#page(String)} parameter definition.
     */
    @Given("(A ){actor} is/are logged in and on the {page} page")
    public void givenActorIsLoggedInAndOnTheExpectedStartingPage(Actor actor, PageObject expectedStartingPage) {
        Credentials credentials = actor.asksFor(LoginCredentials.of(actor));

        actor.wasAbleTo(
                Open.the(swagLabsLoginPage),
                Authenticate.using(credentials),
                Open.the(expectedStartingPage)
        );
    }

    /**
     * Arrange step for ensuring the {@link Actor} is on the expected starting page.
     *
     * @param actor {@link Actor} instance injected by the {@link ParameterDefinitions#actor(String)} parameter definition.
     * @param expectedStartingPage {@link PageObject} instance injected by the {@link ParameterDefinitions#page(String)} parameter definition.
     */
    @Given("{actor} is/are on the {page} page")
    public void givenTheActorIsOnTheExpectedPage(Actor actor, PageObject expectedStartingPage) {
        actor.attemptsTo(Open.the(expectedStartingPage));
    }

    /**
     * Arrange step for ensuring the {@link Actor} is logged in and has the predefined items already in the cart.
     * Uses the {@link Authenticate} task to login via the backend and the {@link InsertInToTheCart} task to populate
     * the cart via the backend to ensure no potential UI issues/changes to those functionalities can prevent the
     * testing of other functionalities.
     *
     * @param actor {@link Actor} instance injected by the {@link ParameterDefinitions#actor(String)} parameter definition.
     * @param items {@link List} of {@link String} of the item names which are to be added to the cart injected by the
     *              {@link ParameterDefinitions#items(String)}.
     */
    @Given("(A ){actor} is/are logged in and they have the following items in the cart: {items}")
    public void givenActorIsLoggedInANdTheyHaveTheSpecifiedItemsInTheCart(Actor actor, List<String> items) {
        Credentials credentials = actor.asksFor(LoginCredentials.of(actor));

        actor.attemptsTo(
                Open.the(swagLabsLoginPage),
                Authenticate.using(credentials),
                InsertInToTheCart.theFollowing(items),
                RememberThat.theValueOf(ITEMS_ADDED_TO_CART).is(items)
        );
    }
}
