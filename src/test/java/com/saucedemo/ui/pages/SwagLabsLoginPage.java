package com.saucedemo.ui.pages;

import com.saucedemo.data.Credentials;
import net.serenitybdd.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("swag.labs.login.page.url")
public class SwagLabsLoginPage extends BasePageObject {

    private final By USERNAME_INPUT = By.cssSelector("input[data-test = 'username']");
    private final By PASSWORD_INPUT = By.cssSelector("input[data-test = 'password']");
    private final By LOGIN_BTN = By.cssSelector("input[data-test = 'login-button']");

    public void loginUsing(Credentials credentials) {
        openUrl();
        enterTextIntoElementLocatedBy(USERNAME_INPUT, credentials.username());
        enterTextIntoElementLocatedBy(PASSWORD_INPUT, credentials.password());
        clickOnTheElementLocatedBy(LOGIN_BTN);
    }
}
