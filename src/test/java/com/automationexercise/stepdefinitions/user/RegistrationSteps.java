package com.automationexercise.stepdefinitions.user;

import com.automationexercise.ui.pages.LoginPage;
import com.automationexercise.ui.pages.SignupPage;
import com.automationexercise.utilities.data.Countries;
import com.automationexercise.utilities.data.DataGenerator;
import com.automationexercise.utilities.data.models.User;
import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Steps;

import java.util.Locale;
import java.util.Random;

public class RegistrationSteps {

    @Steps
    private LoginPage loginPage;
    @Steps
    private SignupPage signupPage;

    @Given("A new user registers")
    public void newUserRegisters() {
        Countries country = Countries.values()[new Random().nextInt(Countries.values().length)];
        DataGenerator dataGenerator = new DataGenerator(new Locale(country.getLocaleCode()));
        User randomUser = dataGenerator.getRandomUser(country);

        loginPage.open();
        loginPage.registerAs(randomUser);
        signupPage.createAccountFor(randomUser);
    }
}
