package com.automationexercise.ui.pages;

import com.automationexercise.utilities.data.models.User;
import org.openqa.selenium.By;
public class LoginPage {

    private BasePage basePage;

    // Login form locators
    private final By LOGIN_EMAIL_INPUT_FIELD = By.cssSelector("input[data-qa='login-email']");
    private final By LOGIN_PASSWORD_INPUT_FIELD = By.cssSelector("input[data-qa='login-password']");
    private final By LOGIN_BUTTON = By.cssSelector("button[data-qa='login-button']");

    // Signup form locators
    private final By SIGNUP_NAME_INPUT_FIELD = By.cssSelector("input[data-qa='signup-name']");
    private final By SIGNUP_EMAIL_INPUT_FIELD = By.cssSelector("input[data-qa='signup-email']");
    private final By SIGNUP_BUTTON = By.cssSelector("button[data-qa='signup-button']");

    public void open() {
        basePage.openUrl("https://automationexercise.com/login");
    }

    public void loginAs(String email, String password) {
        basePage.find(LOGIN_EMAIL_INPUT_FIELD)
                .waitUntilVisible()
                .waitUntilClickable()
                .type(email);

        basePage.find(LOGIN_PASSWORD_INPUT_FIELD)
                .waitUntilVisible()
                .waitUntilClickable()
                .type(password);

        basePage.find(LOGIN_BUTTON)
                .waitUntilVisible()
                .waitUntilClickable()
                .click();
    }

    public void registerAs(User user) {
        basePage.find(SIGNUP_NAME_INPUT_FIELD)
                .waitUntilVisible()
                .waitUntilClickable()
                .type(user.getName().getFullName());

        basePage.find(SIGNUP_EMAIL_INPUT_FIELD)
                .waitUntilVisible()
                .waitUntilClickable()
                .type(user.getEmail());

        basePage.find(SIGNUP_BUTTON)
                .waitUntilVisible()
                .waitUntilClickable()
                .click();
    }
}
