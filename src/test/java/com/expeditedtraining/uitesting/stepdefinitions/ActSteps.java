package com.expeditedtraining.uitesting.stepdefinitions;

import com.expeditedtraining.uitesting.ui.compontents.DraggableDiv;
import com.expeditedtraining.uitesting.user.questions.common.Text;
import com.expeditedtraining.uitesting.user.tasks.tinymce.EnterIntoTheTextEditor;
import com.expeditedtraining.uitesting.user.tasks.swaglabs.cart.RemoveFromCart;
import com.expeditedtraining.uitesting.user.interactions.Click;
import com.expeditedtraining.uitesting.user.interactions.DragAndDrop;
import com.expeditedtraining.uitesting.user.tasks.common.SortTable;
import com.expeditedtraining.uitesting.utils.SerenitySessionVariableKeys;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.RememberThat;
import net.serenitybdd.screenplay.ui.Link;

import java.util.List;
import java.util.Map;

public class ActSteps {

    @When("{actor} sort(s) the table by {string} in {string} order")
    public void userSortsTheTable(Actor actor, String columnName, String order) {
        /*
         Save the values for specified column before sorting. This is needed further down the line to sort with Java
         and then compare against the values saved after sorting using the UI table to verify the table sorting works
         as expected.
         */
        List<String> tableValuesBeforeSorting = actor.asksFor(Text.ofAllRowValuesUnderColumn(columnName));
        actor.attemptsTo(RememberThat.theValueOf(SerenitySessionVariableKeys.TABLE_VALUES_BEFORE_SORT).is(tableValuesBeforeSorting));

        // Sort table
        actor.attemptsTo(SortTable.by(columnName).inOrderOf(order));

        // Save values for specified column after sorting
        List<String> tableValuesAfterSorting = actor.asksFor(Text.ofAllRowValuesUnderColumn(columnName));
        actor.attemptsTo(RememberThat.theValueOf(SerenitySessionVariableKeys.TABLE_VALUES_AFTER_SORT).is(tableValuesAfterSorting));
    }

    @When("{actor} perform(s) a {promptAction}")
    public void userPerformsAPromptAction(Actor actor, Performable performPromptAction) {
        actor.attemptsTo(performPromptAction);
    }

    @When("{actor} open(s) the {string} link")
    public void userOpensLink(Actor actor, String linkText) {
        actor.attemptsTo(Click.on(Link.withText(linkText)));
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
        actor.attemptsTo(RemoveFromCart.itemsCalled(itemNames));
    }

    @When("{actor} input(s) the following content into the text editor")
    public void userInputsTheFollowingContentIntoTextEditor(Actor actor, List<Map<String, String>> requiredContent) {
        actor.attemptsTo(
                EnterIntoTheTextEditor.the(requiredContent),
                RememberThat.theValueOf(SerenitySessionVariableKeys.TEXT_EDITOR_CONTENT).is(requiredContent)
        );
    }
}
