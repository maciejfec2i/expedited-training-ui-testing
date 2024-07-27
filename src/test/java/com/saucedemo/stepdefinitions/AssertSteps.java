package com.saucedemo.stepdefinitions;

import com.saucedemo.actor.questions.Text;
import com.saucedemo.actor.questions.PageTitleTextContent;
import com.saucedemo.actor.questions.Url;
import com.saucedemo.data.ErrorMessage;
import com.saucedemo.ui.components.Error;
import com.saucedemo.ui.components.PageTitle;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;

public class AssertSteps {

    /**
     * Assert step to verify an {@link Actor} was successfully redirected to the expected page after performing an action
     * that should cause a redirect.
     *
     * @param actor {@link Actor} instance injected by the {@link ParameterDefinitions#actor(String)} parameter definition.
     * @param expectedPage {@link PageObject} instance injected by the {@link ParameterDefinitions#page(String)} parameter definition.
     */
    @Then("{actor} should be successfully redirected to the {page} page")
    public void thenActorShouldBeSuccessfullyRedirectedToTheExpectedPage(Actor actor, PageObject expectedPage) {
        String expectedPageUrl = actor.asksFor(Url.of(expectedPage));
        String currentPageUrl = actor.asksFor(Url.ofTheCurrentlyOpenPage());

        actor.attemptsTo(
                Ensure.that(currentPageUrl).isEqualTo(expectedPageUrl),
                Ensure.that(Text.of(PageTitle.ofTheCurrentPage())).isEqualTo(PageTitleTextContent.of(expectedPage))
        );
    }

    /**
     * Assert step to verify an expected {@link ErrorMessage} is displayed after an {@link Actor} performs an action that
     * should cause an error message to be shown.
     *
     * @param actor {@link Actor} instance injected by the {@link ParameterDefinitions#actor(String)} parameter definition.
     * @param expectedErrorMessage {@link  ErrorMessage} instance injected by the {@link ParameterDefinitions#error(String)}
     *                             parameter definition.
     */
    @Then("{actor} should see the {error} error message")
    public void thenActorShouldSeeTheExpectedErrorMessage(Actor actor, ErrorMessage expectedErrorMessage) {
        actor.attemptsTo(
                Ensure.that(Error.container()).isDisplayed(),
                Ensure.that(Text.of(Error.container())).contains(expectedErrorMessage.text())
        );
    }
}
