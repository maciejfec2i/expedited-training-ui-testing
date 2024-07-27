package com.saucedemo.stepdefinitions;

import com.saucedemo.actor.interactions.Select;
import com.saucedemo.actor.questions.LoginCredentials;
import com.saucedemo.actor.questions.Text;
import com.saucedemo.actor.tasks.Login;
import com.saucedemo.data.Credentials;
import com.saucedemo.data.MemoryKeys;
import com.saucedemo.data.comparators.InventoryItemComparator;
import com.saucedemo.ui.components.InventoryItem;
import com.saucedemo.ui.pages.SwagLabsInventoryPage;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.RememberThat;

import java.util.Collection;

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
}
