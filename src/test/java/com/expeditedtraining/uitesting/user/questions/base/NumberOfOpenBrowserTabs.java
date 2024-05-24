package com.expeditedtraining.uitesting.user.questions.base;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The purpose of this class is to retrieve the number of open browser tabs in the current WebDriver session.
 * This class is a Serenity BDD {@link Question} for asserting and/or retrieving information.
 *
 * @author Maciej Fec
 * @version 20/05/2024
 */
public class NumberOfOpenBrowserTabs implements Question<Integer> {

    private final Logger LOGGER = LoggerFactory.getLogger(NumberOfOpenBrowserTabs.class);

    @Override
    public Integer answeredBy(Actor actor) {
        LOGGER.info("{} asks for the number of open browser tabs", actor.getName());

        return BrowseTheWeb.as(actor).getDriver().getWindowHandles().size();
    }
}
