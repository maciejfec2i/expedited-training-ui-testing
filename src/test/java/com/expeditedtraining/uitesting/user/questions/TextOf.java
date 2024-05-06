package com.expeditedtraining.uitesting.user.questions;

import com.expeditedtraining.uitesting.ui.compontents.ItemCard;
import com.expeditedtraining.uitesting.ui.compontents.Table;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

public class TextOf {

    public static Question<List<String>> allTableValuesForColumn(String columnName) {
        return actor -> {
            actor.attemptsTo(
                    WaitUntil.the(Table.ALL_COLUMN_HEADERS, WebElementStateMatchers.isVisible())
            );

            List<String> tableHeaders = BrowseTheWeb.as(actor).findAll(Table.ALL_COLUMN_HEADERS).textContents();
            return BrowseTheWeb
                    .as(actor)
                    .findAll(Table.VALUES_UNDER_COLUMN_WITH_INDEX.of(String.valueOf(tableHeaders.indexOf(columnName) + 1)))
                    .textContents();
        };
    }

    public static Question<String> target(Target target) {
        return Question.about("Text of " + target).answeredBy(
                actor -> {
                    WaitUntil.the(target, WebElementStateMatchers.isVisible());
                    return BrowseTheWeb.as(actor).find(target).getText();
                }
        );
    }
}
