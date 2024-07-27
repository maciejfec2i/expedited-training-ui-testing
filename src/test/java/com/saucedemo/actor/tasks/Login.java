package com.saucedemo.actor.tasks;

import com.saucedemo.actor.interactions.Click;
import com.saucedemo.actor.interactions.Type;
import com.saucedemo.data.Credentials;
import com.saucedemo.ui.components.LoginForm;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Login implements Performable, IsHidden {

    private final Logger LOGGER = LoggerFactory.getLogger(Login.class);

    private final Credentials credentials;

    public Login(Credentials credentials) {
        this.credentials = credentials;
    }

    public static Login using(Credentials credentials) {
        return Tasks.instrumented(Login.class, credentials);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} attempts to login using {}", actor.getName(), credentials);

        actor.attemptsTo(
                Type.theValue(credentials.username()).into(LoginForm.USERNAME_FIELD),
                Type.theValue(credentials.password()).into(LoginForm.PASSWORD_FIELD),
                Click.on(LoginForm.LOGIN_BUTTON)
        );
    }
}
