package com.saucedemo.stepdefinitions;

import com.saucedemo.actor.interactions.Select;
import com.saucedemo.actor.questions.LoginCredentials;
import com.saucedemo.actor.questions.Text;
import com.saucedemo.actor.tasks.AddToCart;
import com.saucedemo.actor.tasks.Login;
import com.saucedemo.actor.tasks.RemoveFromCart;
import com.saucedemo.data.Credentials;
import com.saucedemo.data.MemoryKeys;
import com.saucedemo.data.comparators.InventoryItemComparator;
import com.saucedemo.ui.components.InventoryItem;
import com.saucedemo.ui.pages.SwagLabsCartPage;
import com.saucedemo.ui.pages.SwagLabsInventoryPage;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.RememberThat;

import java.util.Collection;
import java.util.List;

import static com.saucedemo.data.MemoryKeys.ITEMS_ADDED_TO_CART;
import static com.saucedemo.data.MemoryKeys.ITEMS_REMOVED_FROM_CART;

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

    /**
     * Act step for sorting items on the {@link SwagLabsInventoryPage} by the provided filter. Captures the inventory item
     * values based on the filter before the items are sorted to later sort them using the {@link InventoryItemComparator},
     * and after the items are sorted via the UI.
     *
     * @param actor {@link Actor} instance injected by the {@link ParameterDefinitions#actor(String)} parameter definition.
     * @param filter {@link String} instance of a value available in the {@link SwagLabsInventoryPage#PRODUCT_SORT_DROPDOWN}.
     */
    @When("{actor} sort(s) items by {string}")
    public void whenActorSortsItemsByFilter(Actor actor, String filter) {
        Collection<String> itemValuesBeforeSorting = actor.asksFor(Text.ofEach(InventoryItem.componentBasedOn(filter)));

        actor.attemptsTo(Select.theOptionWithTextOf(filter).from(SwagLabsInventoryPage.PRODUCT_SORT_DROPDOWN));

        Collection<String> itemValuesAfterSorting = actor.asksFor(Text.ofEach(InventoryItem.componentBasedOn(filter)));

        actor.attemptsTo(
                RememberThat.theValueOf(MemoryKeys.ITEM_VALUES_BEFORE_SORT).is(itemValuesBeforeSorting),
                RememberThat.theValueOf(MemoryKeys.ITEM_VALUES_AFTER_SORT).is(itemValuesAfterSorting)
        );
    }

    /**
     * Act step for adding items to cart via the {@link SwagLabsInventoryPage}. Takes in a {@link String} of comma
     * separated item names i.e "Sauce Labs Bike Light, Sauce Labs Fleece Jacket", and uses the
     * {@link ParameterDefinitions#items(String)} to translate it into a {@link List} of {@link String}.
     *
     * @param actor {@link Actor} instance injected by the {@link ParameterDefinitions#actor(String)} parameter definition.
     * @param items {@link List} of {@link String} of the item names which are to be added to the cart injected by the
     *              {@link ParameterDefinitions#items(String)}.
     */
    @When("{actor} add(s) the following items to the cart: {items}")
    public void whenActorAddsTheFollowingItemsToTheCart(Actor actor, List<String> items) {
        actor.attemptsTo(
                AddToCart.theFollowing(items),
                RememberThat.theValueOf(ITEMS_ADDED_TO_CART).is(items)
        );
    }


    /**
     * Act step for removing items from cart via the {@link SwagLabsInventoryPage} or the {@link SwagLabsCartPage}.
     * Takes in a {@link String} of comma separated item names i.e "Sauce Labs Bike Light, Sauce Labs Fleece Jacket",
     * and uses the {@link ParameterDefinitions#items(String)} to translate it into a {@link List} of {@link String}.
     *
     * @param actor {@link Actor} instance injected by the {@link ParameterDefinitions#actor(String)} parameter definition.
     * @param items {@link List} of {@link String} of the item names which are to be removed from the cart injected by the
     *              {@link ParameterDefinitions#items(String)}.
     */
    @When("{actor} remove(s) the following items from the cart: {items}")
    public void whenActorRemovesTheFollowingItemsFromTheCart(Actor actor, List<String> items) {
        actor.attemptsTo(
                RemoveFromCart.theFollowing(items),
                RememberThat.theValueOf(ITEMS_REMOVED_FROM_CART).is(items)
        );
    }
}
