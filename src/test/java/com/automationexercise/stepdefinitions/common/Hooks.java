package com.automationexercise.stepdefinitions.common;

import com.automationexercise.ui.pages.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private BasePage basePage;

    @Before
    public void chromeExtensionSetup() {
        basePage.getDriver();
    }

    @After
    public void removeCreatedUser() {
        
    }
}
