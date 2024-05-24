package com.expeditedtraining.uitesting.stepdefinitions;

import com.expeditedtraining.uitesting.ui.compontents.DraggableDiv;
import com.expeditedtraining.uitesting.ui.compontents.HTML;
import com.expeditedtraining.uitesting.ui.pages.theinternet.JavaScriptAlertsPage;
import com.expeditedtraining.uitesting.ui.pages.theinternet.TinyMCETextEditorPage;
import com.expeditedtraining.uitesting.user.interactions.Click;
import com.expeditedtraining.uitesting.user.interactions.Switch;
import com.expeditedtraining.uitesting.user.questions.*;
import com.expeditedtraining.uitesting.user.questions.Number;
import com.expeditedtraining.uitesting.user.questions.Text;
import com.expeditedtraining.uitesting.user.questions.swaglabs.Cart;
import com.expeditedtraining.uitesting.user.questions.tinymce.FontAlignment;
import com.expeditedtraining.uitesting.user.questions.tinymce.FontFormatting;
import com.expeditedtraining.uitesting.user.questions.tinymce.FontStyle;
import com.expeditedtraining.uitesting.utils.SerenitySessionVariableKeys;
import com.expeditedtraining.uitesting.utils.comparators.MonetaryValueComparator;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ensure.web.ElementLocated;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AssertSteps {

    private final MonetaryValueComparator monetaryValueComparator = new MonetaryValueComparator();

    @Then("the rows should be sorted correctly by {string} in {string} order")
    public void rowsShouldBeSortedCorrectly(String by, String order) {
        Actor actor = OnStage.theActorInTheSpotlight();

        List<String> tableValuesSortedViaUI = actor.recall(SerenitySessionVariableKeys.TABLE_VALUES_AFTER_SORT);
        /*
         * The text of these is retrieved unsorted. We sort them using Java and compare against the values retrieved
         * after sorting using UI to verify table sorting works.
         */
        List<String> tableValuesSortedViaJava = actor.recall(SerenitySessionVariableKeys.TABLE_VALUES_BEFORE_SORT);

        if (by.equalsIgnoreCase("due")) {
            tableValuesSortedViaJava.sort(monetaryValueComparator);
        } else {
            Collections.sort(tableValuesSortedViaJava);
        }

        if(order.equalsIgnoreCase("descending")) Collections.reverse(tableValuesSortedViaJava);

        actor.attemptsTo(Ensure.that(tableValuesSortedViaUI).containsExactlyElementsFrom(tableValuesSortedViaJava));
    }

    @Then("the page should display that {string}")
    public void pageShouldDisplayExpectedText(String expectedText) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(Text.of(JavaScriptAlertsPage.ALERT_ACTION_RESULT)).isEqualTo(expectedText)
        );
    }

    @Then("a new tab should be opened")
    public void newTabShouldBeOpened() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(Ensure.that(Number.ofOpenTabs()).isGreaterThan(1));
    }

    @Then("the {actor} should be able to switch to the tab titled {string}")
    public void userShouldBeAbleToSwitchToTabAndSeePageContent(Actor actor, String expectedBrowserTabTitle) {
        actor.attemptsTo(
                Switch.toBrowserTabWithTitleOf(expectedBrowserTabTitle),
                Ensure.that(ElementLocated.by((HTML.ELEMENT_WITH_TAG.of("html")))).isDisplayed()
        );
    }

    @Then("the elements should be as follows")
    public void elementsShouldBeAsFollows(List<Map<String, String>> detailsOfElements) {
        Actor actor = OnStage.theActorInTheSpotlight();

        for(Map<String, String> expectedElementDetails : detailsOfElements) {
            actor.attemptsTo(
                    Ensure.that(Attribute.of(DraggableDiv.WITH_TEXT.of(expectedElementDetails.get("element-name")), "id"))
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
    public void toolbarShouldReflectTheCorrectFormatForEachInputtedContentSection() {
        Actor actor = OnStage.theActorInTheSpotlight();
        List<Map<String, String>> textEditorContent = actor.recall(SerenitySessionVariableKeys.TEXT_EDITOR_CONTENT);

        for(Map<String, String> content : textEditorContent) {
            actor.attemptsTo(
                    Switch.toFrame(TinyMCETextEditorPage.RICH_TEXT_AREA_IFRAME),
                    Click.on(TinyMCETextEditorPage.richTextAreaContentSectionWithTextOf(content.get("text"))),
                    Switch.toDefaultContext(),
                    Ensure.that(FontStyle.ariaCheckedAttributeFor(content.get("font-style"))).isEqualTo("true"),
                    Ensure.that(FontAlignment.ariaPressedAttributeFor(content.get("font-alignment"))).isEqualTo("true")
            );

            if(!content.get("font-formatting").equalsIgnoreCase("normal")) {
                actor.attemptsTo(
                        Ensure.that(FontFormatting.ariaPressedAttributeFor(content.get("font-formatting"))).isEqualTo("true")
                );
            }
        }
    }
}
