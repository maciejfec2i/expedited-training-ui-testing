package com.saucedemo.ui.components;

import net.serenitybdd.screenplay.targets.Target;

public class LoginForm {

    public static final Target USERNAME_FIELD = Target.the("login form username field").locatedBy("input[data-test = 'username']");
    public static final Target PASSWORD_FIELD = Target.the("login form password field").locatedBy("input[data-test = 'password']");
    public static final Target LOGIN_BUTTON = Target.the("login button").locatedBy("input[data-test = 'login-button']");
}
