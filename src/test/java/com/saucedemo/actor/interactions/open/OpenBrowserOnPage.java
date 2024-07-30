package com.saucedemo.actor.interactions.open;

import com.saucedemo.actor.questions.Url;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.conditions.Check;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenBrowserOnPage implements Performable, IsHidden {

    private final Logger LOGGER = LoggerFactory.getLogger(OpenBrowserOnPage.class);

    private final PageObject targetPage;

    public OpenBrowserOnPage(PageObject targetPage) {
        this.targetPage = targetPage;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String currentPageUrl = actor.asksFor(Url.ofTheCurrentlyOpenPage());
        String targetPageUrl = actor.asksFor(Url.of(targetPage));

        LOGGER.info("{} attempts to open the browser on {}", actor.getName(), targetPageUrl);

        actor.attemptsTo(Check.whether(!currentPageUrl.equals(targetPageUrl)).andIfSo(Open.url(targetPageUrl)));
    }
}
