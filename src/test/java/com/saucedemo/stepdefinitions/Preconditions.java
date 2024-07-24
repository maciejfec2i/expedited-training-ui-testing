package com.saucedemo.stepdefinitions;

import com.saucedemo.utils.Timeouts;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Preconditions {

    @BeforeAll
    public static void setUpTimeOuts() {
        Timeouts.set();
        System.out.println("VISIBILITY TIMEOUT: " + Timeouts.specifiedElementVisibleTimeout());
        System.out.println("CLICKABLE TIMEOUT: " + Timeouts.specifiedElementClickableTimeout());
    }

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
}
