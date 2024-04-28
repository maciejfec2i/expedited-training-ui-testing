package com.expeditedtraining.uitesting.stepdefinitions;

import com.expeditedtraining.uitesting.user.actions.ui.SortTable;
import com.expeditedtraining.uitesting.user.actions.ui.TextOf;
import com.expeditedtraining.uitesting.utils.SerenitySessionVariableKeys;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;

public class ActSteps {

    @When("{user} sort the table by {string} in {string} order")
    public void userSortsTheTable(Actor user, String by, String order) throws InterruptedException {
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
}
