package com.expeditedtraining.uitesting.user.actions.api;

import com.expeditedtraining.uitesting.user.Credentials;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Cookie;

public class Authenticate implements Performable {

    private Credentials user;

    public Authenticate(Credentials user) {
        this.user = user;
    }

    public static Authenticate with(Credentials credentials) {
        return Tasks.instrumented(Authenticate.class, credentials);
    }

    @Step("Authenticate as #user")
    @Override
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).getDriver().manage().addCookie(new Cookie("session-username", user.username()));
    }
}
