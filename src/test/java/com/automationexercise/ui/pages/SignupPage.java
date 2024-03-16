package com.automationexercise.ui.pages;

import com.automationexercise.utilities.data.models.User;
import org.openqa.selenium.By;

public class SignupPage {

    private BasePage basePage;

    private final By NAME_INPUT_FIELD = By.cssSelector("input[data-qa='name']");
    private final By PASSWORD_INPUT_FIELD = By.cssSelector("input[data-qa='password']");
    private final By FIRST_NAME_INPUT_FIELD = By.id("first_name");
    private final By LAST_NAME_INPUT_FIELD = By.id("last_name");
    private final By ADDRESS_INPUT_FIELD = By.id("address1");
    private final By COUNTRY_DROPDOWN_FIELD = By.id("country");
    private final By STATE_NAME_INPUT_FIELD = By.id("state");
    private final By CITY_NAME_INPUT_FIELD = By.id("city");
    private final By ZIPCODE_NAME_INPUT_FIELD = By.id("zipcode");
    private final By MOBILE_NUMBER_NAME_INPUT_FIELD = By.id("mobile_number");
    private final By CREATE_ACCOUNT_BUTTON = By.cssSelector("button[data-qa='create-account']");

    public void createAccountFor(User user) {
        basePage.find(NAME_INPUT_FIELD)
                .waitUntilVisible()
                .waitUntilClickable()
                .type(user.getName().getFullName());

        basePage.find(PASSWORD_INPUT_FIELD)
                .waitUntilVisible()
                .waitUntilClickable()
                .type("P@5$w0rd127127");

        basePage.find(FIRST_NAME_INPUT_FIELD)
                .waitUntilVisible()
                .waitUntilClickable()
                .type(user.getName().getFirstName());

        basePage.find(LAST_NAME_INPUT_FIELD)
                .waitUntilVisible()
                .waitUntilClickable()
                .type(user.getName().getLastName());

        basePage.find(ADDRESS_INPUT_FIELD)
                .waitUntilVisible()
                .waitUntilClickable()
                .type(user.getAddress().getAddressLine1());

        basePage.find(COUNTRY_DROPDOWN_FIELD)
                .waitUntilVisible()
                .waitUntilClickable()
                .selectByValue(user.getAddress().getCountry());

        basePage.find(STATE_NAME_INPUT_FIELD)
                .waitUntilVisible()
                .waitUntilClickable()
                .type(user.getAddress().getState());

        basePage.find(CITY_NAME_INPUT_FIELD)
                .waitUntilVisible()
                .waitUntilClickable()
                .type(user.getAddress().getCity());

        basePage.find(ZIPCODE_NAME_INPUT_FIELD)
                .waitUntilVisible()
                .waitUntilClickable()
                .type(user.getAddress().getZipcode());

        basePage.find(MOBILE_NUMBER_NAME_INPUT_FIELD)
                .waitUntilVisible()
                .waitUntilClickable()
                .type(user.getPhoneNumber());

        basePage.find(CREATE_ACCOUNT_BUTTON)
                .waitUntilVisible()
                .waitUntilClickable()
                .click();
    }
}
