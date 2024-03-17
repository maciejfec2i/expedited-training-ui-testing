package com.automationexercise.ui.pages;

import net.serenitybdd.core.pages.WebElementState;
import org.openqa.selenium.By;

public class AccountCreatedPage {
    private BasePage basePage;

    private final By ACCOUNT_CREATED_TITLE = By.cssSelector("h2[data-qa='account-created']");

    public WebElementState accountCreatedTitle() {
        return basePage.find(ACCOUNT_CREATED_TITLE);
    }
}
