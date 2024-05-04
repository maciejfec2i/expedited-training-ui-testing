package com.expeditedtraining.uitesting.stepdefinitions;

import com.expeditedtraining.uitesting.ui.compontents.DraggableDiv;
import com.expeditedtraining.uitesting.user.actions.ui.DragAndDrop;
import com.expeditedtraining.uitesting.user.actions.ui.SortTable;
import com.expeditedtraining.uitesting.user.actions.ui.base.ClickOn;
import com.expeditedtraining.uitesting.user.questions.TextOf;
import com.expeditedtraining.uitesting.utils.SerenitySessionVariableKeys;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Drag;
import net.serenitybdd.screenplay.ui.Link;

public class ActSteps {

    @When("{user} sort(s) the table by {string} in {string} order")
    public void userSortsTheTable(Actor user, String by, String order) {
        // Save values for specified column before sorting
        Serenity
                .setSessionVariable(SerenitySessionVariableKeys.TABLE_VALUES_BEFORE_SORT)
                .to(user.asksFor(TextOf.allTableValuesForColumn(by)));

        user.attemptsTo(
                SortTable.by(by).inOrder(order)
        );

        // Save values for specified column after sorting
        Serenity
                .setSessionVariable(SerenitySessionVariableKeys.TABLE_VALUES_AFTER_SORT)
                .to(user.asksFor(TextOf.allTableValuesForColumn(by)));
    }

    @When("{user} perform(s) a {promptAction}")
    public void userPerformsAPromptAction(Actor user, Performable performPromptAction) {
        user.attemptsTo(
                performPromptAction
        );
    }

    @When("{user} open(s) the {string} link")
    public void userOpensLink(Actor user, String linkText) {
        user.attemptsTo(
                ClickOn.the(Link.withText(linkText))
        );
    }

    @When("{user} drag(s) and drop(s) element {string} over element {string}")
    public void userDragsAndDropsElementOverAnotherElement(Actor user, String firstElementText, String secondElementText) {
        user.attemptsTo(
                DragAndDrop
                        .element(DraggableDiv.WITH_TEXT.of(firstElementText))
                        .on(DraggableDiv.WITH_TEXT.of(secondElementText))
        );
    }
}
