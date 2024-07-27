package com.saucedemo.stepdefinitions;

import com.saucedemo.actor.questions.Text;
import com.saucedemo.actor.questions.PageTitleTextContent;
import com.saucedemo.actor.questions.Url;
import com.saucedemo.data.ErrorMessage;
import com.saucedemo.data.SortOrder;
import com.saucedemo.data.comparators.InventoryItemComparator;
import com.saucedemo.ui.components.Error;
import com.saucedemo.ui.components.PageTitle;
import com.saucedemo.ui.pages.SwagLabsInventoryPage;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.Collection;

import static com.saucedemo.data.MemoryKeys.*;

public class AssertSteps {

    /**
     * Assert step to verify an {@link Actor} was successfully redirected to the expected page after performing an action
     * that should cause a redirect.
     *
     * @param actor {@link Actor} instance injected by the {@link ParameterDefinitions#actor(String)} parameter definition.
     * @param expectedPage {@link PageObject} instance injected by the {@link ParameterDefinitions#page(String)} parameter definition.
     */
    @Then("{actor} should be successfully redirected to the {page} page")
    public void thenActorShouldBeSuccessfullyRedirectedToTheExpectedPage(Actor actor, PageObject expectedPage) {
        String expectedPageUrl = actor.asksFor(Url.of(expectedPage));
        String currentPageUrl = actor.asksFor(Url.ofTheCurrentlyOpenPage());

        actor.attemptsTo(
                Ensure.that(currentPageUrl).isEqualTo(expectedPageUrl),
                Ensure.that(Text.of(PageTitle.ofTheCurrentPage())).isEqualTo(PageTitleTextContent.of(expectedPage))
        );
    }

    /**
     * Assert step to verify an expected {@link ErrorMessage} is displayed after an {@link Actor} performs an action that
     * should cause an error message to be shown.
     *
     * @param actor {@link Actor} instance injected by the {@link ParameterDefinitions#actor(String)} parameter definition.
     * @param expectedErrorMessage {@link  ErrorMessage} instance injected by the {@link ParameterDefinitions#error(String)}
     *                             parameter definition.
     */
    @Then("{actor} should see the {error} error message")
    public void thenActorShouldSeeTheExpectedErrorMessage(Actor actor, ErrorMessage expectedErrorMessage) {
        actor.attemptsTo(
                Ensure.that(Error.container()).isDisplayed(),
                Ensure.that(Text.of(Error.container())).contains(expectedErrorMessage.text())
        );
    }

    /**
     * Assert step to verify that the items of the {@link SwagLabsInventoryPage} sorted via the UI have been sorted
     * correctly based on the specified criteria and {@link SortOrder}. Uses the {@link InventoryItemComparator} to
     * sort programmatically the item values captured before they have been sorted via the UI.
     *
     * @param criteria {@link String} instance of the criteria by which the items have been sorted.
     * @param order {@link SortOrder} instance of the order in which the items have been sorted in injected by
     *              {@link ParameterDefinitions#order(String)}.
     */
    @Then("the items should be sorted by {string} in {order} order")
    public void thenTheItemsShouldBeSortedByCriteriaInDirections(String criteria, SortOrder order) {
        Actor actor = OnStage.theActorInTheSpotlight();

        Collection<String> itemValuesBeforeSorting = actor.recall(ITEM_VALUES_BEFORE_SORT);
        Collection<String> itemValuesSortedViaUI = actor.recall(ITEM_VALUES_AFTER_SORT);
        Collection<String> itemValuesSortedByComparator = InventoryItemComparator.sortValuesOf(itemValuesBeforeSorting).inOrderOf(order);

        actor.attemptsTo(Ensure.that(itemValuesSortedViaUI).containsExactlyElementsFrom(itemValuesSortedByComparator));
    }
}
