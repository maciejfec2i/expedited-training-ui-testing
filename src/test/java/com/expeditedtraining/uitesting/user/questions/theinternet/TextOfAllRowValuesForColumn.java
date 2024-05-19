package com.expeditedtraining.uitesting.user.questions.theinternet;

import com.expeditedtraining.uitesting.ui.compontents.Table;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class TextOfAllRowValuesForColumn implements Question<List<String>> {

    private final Logger LOGGER = LoggerFactory.getLogger(TextOfAllRowValuesForColumn.class);

    private final String columnName;

    public TextOfAllRowValuesForColumn(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        LOGGER.info("{} asks for the text of all the rows under the '{}' column", actor.getName(), columnName);

        actor.attemptsTo(WaitUntil.the(Table.ALL_COLUMN_HEADERS, isVisible()));
        List<String> tableHeaders = BrowseTheWeb.as(actor).findAll(Table.ALL_COLUMN_HEADERS).textContents();

        return BrowseTheWeb
                .as(actor)
                .findAll(Table.VALUES_UNDER_COLUMN_WITH_INDEX.of(String.valueOf(tableHeaders.indexOf(columnName) + 1)))
                .textContents();
    }
}
