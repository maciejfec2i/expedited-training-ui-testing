package com.expeditedtraining.uitesting.user.actions.ui;

import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.DriverTask;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;
import java.util.stream.Collectors;

public class SwitchToNewWindow implements Performable, IsHidden {

    @Override
    public <T extends Actor> void performAs(T user) {
        String currentWindowHandle = BrowseTheWeb.as(user).getDriver().getWindowHandle();
        user.attemptsTo(WaitUntil.the(ExpectedConditions.numberOfWindowsToBe(2)));
        Set<String> allWindowHandles = BrowseTheWeb.as(user).getDriver().getWindowHandles();
        String handleToSwitchTo = allWindowHandles.stream().filter(handle -> !handle.equalsIgnoreCase(currentWindowHandle)).collect(Collectors.toList()).get(0);
        BrowseTheWeb.as(user).getDriver().switchTo().window(handleToSwitchTo);
    }
}
