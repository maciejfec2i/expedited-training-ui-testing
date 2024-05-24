package com.expeditedtraining.uitesting.user.interactions.silent;

import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.targets.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * The purpose of this class is to silently (without reporting) switch to a new browser tab by that tabs title by looping
 * through all open browser tabs that are not the current browser tab in focus, and comparing if the title of the newly
 * switched to tab, is equal to the provided browser tab title.
 *
 * @author Maciej Fec
 * @version 14/05/2024
 */
public class SilentlySwitchToBrowserTabByTitle implements Performable, IsSilent {

    private final Logger LOGGER = LoggerFactory.getLogger(SilentlySwitchToBrowserTabByTitle.class);

    private final String tabTitle;

    public SilentlySwitchToBrowserTabByTitle(String tabTitle) {
        this.tabTitle = tabTitle;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} attempts to switch to the browser tab with title of '{}'", actor.getName(), tabTitle);

        Set<String> allTabHandles = BrowseTheWeb.as(actor).getDriver().getWindowHandles();
        String currentTabHandle = BrowseTheWeb.as(actor).getDriver().getWindowHandle();
        Set<String> handlesToCheck = allTabHandles.stream().filter(handle -> !handle.equalsIgnoreCase(currentTabHandle)).collect(Collectors.toSet());

        for(String handle : handlesToCheck) {
            actor.attemptsTo(Switch.toWindow(handle));
            String newTabTitle = BrowseTheWeb.as(actor).getTitle();

            if(newTabTitle.equalsIgnoreCase(tabTitle)) break;
        }
    }
}
