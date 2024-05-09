package com.expeditedtraining.uitesting.stepdefinitions;

import com.expeditedtraining.uitesting.ui.compontents.DraggableDiv;
import com.expeditedtraining.uitesting.ui.compontents.HTML;
import com.expeditedtraining.uitesting.ui.pages.JavaScripAlertsPage;
import com.expeditedtraining.uitesting.ui.pages.TinyMCETextEditorPage;
import com.expeditedtraining.uitesting.user.actions.ui.SwitchTo;
import com.expeditedtraining.uitesting.user.actions.ui.base.ClickOn;
import com.expeditedtraining.uitesting.user.questions.*;
import com.expeditedtraining.uitesting.utils.SerenitySessionVariableKeys;
import com.expeditedtraining.uitesting.utils.comparators.MonetaryValueComparator;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ensure.web.ElementLocated;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AssertSteps {

    private final MonetaryValueComparator monetaryValueComparator = new MonetaryValueComparator();

    @Then("the rows should be sorted correctly by {string} in {string} order")
    public void rowsShouldBeSortedCorrectly(String by, String order) {
        List<String> tableValuesSortedViaUI = Serenity.sessionVariableCalled(SerenitySessionVariableKeys.TABLE_VALUES_AFTER_SORT);

        /*
         * The text of these is retrieved unsorted. We sort them using Java and compare against the values retrieved
         * after sorting using UI to verify table sorting works.
         */
        List<String> tableValuesSortedViaJava = Serenity.sessionVariableCalled(SerenitySessionVariableKeys.TABLE_VALUES_BEFORE_SORT);

        if (by.equalsIgnoreCase("due")) {
            tableValuesSortedViaJava.sort(monetaryValueComparator);
        } else {
            Collections.sort(tableValuesSortedViaJava);
        }

        if(order.equalsIgnoreCase("descending")) Collections.reverse(tableValuesSortedViaJava);

        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(tableValuesSortedViaUI).containsExactlyElementsFrom(tableValuesSortedViaJava)
        );
    }

    @Then("the page should display that {string}")
    public void pageShouldDisplayExpectedText(String expectedText) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(TextOf.target(JavaScripAlertsPage.ALERT_ACTION_RESULT)).isEqualTo(expectedText)
        );
    }

    @Then("a new tab should be opened")
    public void newTabShouldBeOpened() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(NumberOf.openTabs()).isEqualTo(2)
        );
    }

    @Then("the {actor} should be able to switch to the tab and see the page content")
    public void userShouldBeAbleToSwitchToTabAndSeePageContent(Actor actor) {
        actor.attemptsTo(
                SwitchTo.aNewWindow(),
                Ensure.that(ElementLocated.by((HTML.ELEMENT_WITH_TAG.of("html")))).isDisplayed()
        );
    }

    @Then("the elements should be as follows")
    public void elementsShouldBeAsFollows(List<Map<String, String>> detailsOfElements) {
        for(Map<String, String> expectedElementDetails : detailsOfElements) {
            OnStage.theActorInTheSpotlight().attemptsTo(
                    Ensure.that(IDAttribute.of(DraggableDiv.WITH_TEXT.of(expectedElementDetails.get("element-name"))))
                            .isEqualTo(expectedElementDetails.get("element-column"))
            );
        }
    }

    @Then("the following items should no longer be in the cart: {itemNames}")
    public void followingItemsShouldNoLongerBeInTheCart(List<String> removedItems) {
        Actor actor = OnStage.theActorInTheSpotlight();
        List<String> cartItems = actor.asksFor(Cart.items());

        actor.attemptsTo(Ensure.that(cartItems).doesNotContainElementsFrom(removedItems));
    }

    @Then("the toolbar should reflect the correct format for each inputted content section")
    public void toolbarShouldReflectTheCorrectFormatForEachInputtedContentSection() throws InterruptedException {
        Actor actor = OnStage.theActorInTheSpotlight();
        List<Map<String, String>> textEditorContent = actor.recall(SerenitySessionVariableKeys.TEXT_EDITOR_CONTENT);

        for(Map<String, String> content : textEditorContent) {
            actor.attemptsTo(
                    SwitchTo.frame(TinyMCETextEditorPage.RICH_TEXT_AREA_IFRAME),
                    ClickOn.the(TinyMCETextEditorPage.richTextAreaContentSectionWithTextOf(content.get("text"))),
                    Switch.toDefaultContext()
            );
        }
    }
}
