package com.expeditedtraining.uitesting.user.questions.base;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberOfOpenBrowserTabs implements Question<Integer> {

    private final Logger LOGGER = LoggerFactory.getLogger(NumberOfOpenBrowserTabs.class);

    @Override
    public Integer answeredBy(Actor actor) {
        LOGGER.info("{} asks for the number of open browser tabs", actor.getName());

        return BrowseTheWeb.as(actor).getDriver().getWindowHandles().size();
    }
}
