package com.saucedemo.actor.tasks;

import com.saucedemo.data.Credentials;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Cookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Authenticate implements Performable {

    private final Logger LOGGER = LoggerFactory.getLogger(Authenticate.class);

    private final Credentials credentials;

    public Authenticate(Credentials credentials) {
        this.credentials = credentials;
    }

    public static Performable using(Credentials credentials) {
        return Tasks.instrumented(Authenticate.class, credentials);
    }

    @Override
    @Step("{0} authenticates using #credentials")
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} attempts to authenticate using {}", actor.getName(), credentials);

        BrowseTheWeb.as(actor).getDriver().manage().addCookie(new Cookie("session-username", credentials.username()));
    }
}
