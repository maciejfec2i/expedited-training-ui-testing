package com.saucedemo.actor.questions.url;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UrlOfCurrentPage implements Question<String> {

    private final Logger LOGGER = LoggerFactory.getLogger(UrlOfPageObject.class);

    @Override
    public String answeredBy(Actor actor) {
        LOGGER.info("{} asks for the URL of the currently open page", actor.getName());

        return BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
    }
}
