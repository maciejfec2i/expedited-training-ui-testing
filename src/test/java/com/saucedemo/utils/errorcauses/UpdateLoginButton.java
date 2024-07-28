package com.saucedemo.utils.errorcauses;

import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class UpdateLoginButton implements Performable, IsSilent {

    public static Performable toSignInButton() {
        return Tasks.instrumented(UpdateLoginButton.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String script = "document.getElementById('login-button').setAttribute('data-test', 'sign-in-button');";

        BrowseTheWeb.as(actor).evaluateJavascript(script);
    }
}
