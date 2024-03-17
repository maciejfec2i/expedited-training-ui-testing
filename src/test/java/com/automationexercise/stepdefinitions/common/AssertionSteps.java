package com.automationexercise.stepdefinitions.common;

import com.automationexercise.ui.pages.AccountCreatedPage;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;
import org.assertj.core.api.Assertions;

public class AssertionSteps {

    @Steps
    private AccountCreatedPage accountCreatedPage;

    @Then("the account should be created successfully")
    public void theAccountShouldBeCreatedSuccessfully() {
        Assertions.assertThat(accountCreatedPage.accountCreatedTitle().isVisible()).isTrue();
    }
}
