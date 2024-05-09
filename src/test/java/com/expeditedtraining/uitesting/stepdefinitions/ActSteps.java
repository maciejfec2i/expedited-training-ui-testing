package com.expeditedtraining.uitesting.stepdefinitions;

import com.expeditedtraining.uitesting.ui.compontents.DraggableDiv;
import com.expeditedtraining.uitesting.user.actions.ui.DragAndDrop;
import com.expeditedtraining.uitesting.user.actions.ui.Input;
import com.expeditedtraining.uitesting.user.actions.ui.RemoveCartItems;
import com.expeditedtraining.uitesting.user.actions.ui.SortTable;
import com.expeditedtraining.uitesting.user.actions.ui.base.ClickOn;
import com.expeditedtraining.uitesting.user.questions.TextOf;
import com.expeditedtraining.uitesting.utils.SerenitySessionVariableKeys;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.RememberThat;
import net.serenitybdd.screenplay.ui.Link;

import java.util.List;
import java.util.Map;

public class ActSteps {

    @When("{actor} sort(s) the table by {string} in {string} order")
    public void userSortsTheTable(Actor actor, String by, String order) {
        // Save values for specified column before sorting
        Serenity
                .setSessionVariable(SerenitySessionVariableKeys.TABLE_VALUES_BEFORE_SORT)
                .to(actor.asksFor(TextOf.allTableValuesForColumn(by)));

        actor.attemptsTo(
                SortTable.by(by).inOrder(order)
        );

        // Save values for specified column after sorting
        Serenity
                .setSessionVariable(SerenitySessionVariableKeys.TABLE_VALUES_AFTER_SORT)
                .to(actor.asksFor(TextOf.allTableValuesForColumn(by)));
    }

    @When("{actor} perform(s) a {promptAction}")
    public void userPerformsAPromptAction(Actor actor, Performable performPromptAction) {
        actor.attemptsTo(
                performPromptAction
        );
    }

    @When("{actor} open(s) the {string} link")
    public void userOpensLink(Actor actor, String linkText) {
        actor.attemptsTo(
                ClickOn.the(Link.withText(linkText))
        );
    }

    @When("{actor} drag(s) and drop(s) element {string} over element {string}")
    public void userDragsAndDropsElementOverAnotherElement(Actor actor, String firstElementText, String secondElementText) {
        actor.attemptsTo(
                DragAndDrop
                        .element(DraggableDiv.WITH_TEXT.of(firstElementText))
                        .on(DraggableDiv.WITH_TEXT.of(secondElementText))
        );
    }

    @When("{actor} remove(s) the following items from the cart: {itemNames}")
    public void userRemovesTheFollowingItemsFromCart(Actor actor, List<String> itemNames) {
        actor.attemptsTo(RemoveCartItems.called(itemNames));
    }

    @When("{actor} input(s) the following content into the text editor")
    public void userInputsTheFollowingContentIntoTextEditor(Actor actor, List<Map<String, String>> content) {
        actor.attemptsTo(
                Input.contentIntoTextEditor(content),
                RememberThat.theValueOf(SerenitySessionVariableKeys.TEXT_EDITOR_CONTENT).is(content)
        );
    }
}
