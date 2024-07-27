package com.saucedemo.stepdefinitions;

import com.saucedemo.actor.interactions.Open;
import io.cucumber.java.en.Given;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;

public class ArrangeSteps {

    /**
     * Arrange step for navigating to a specific page of the Swag Labs Site. To be used to ensure the {@link Actor}
     * is on the page on which Act steps are to be performed.
     *
     * @param actor {@link Actor} instance injected by the {@link ParameterDefinitions#actor(String)} parameter definition.
     * @param page {@link PageObject} instance injected by the {@link ParameterDefinitions#page(String)} parameter definition.
     */
    @Given("(A ){actor} was able to open the {page} page")
    public void givenActorWasAbleToOpenTheBrowserOnThePage(Actor actor, PageObject page) {
        actor.wasAbleTo(Open.the(page));
    }
}
