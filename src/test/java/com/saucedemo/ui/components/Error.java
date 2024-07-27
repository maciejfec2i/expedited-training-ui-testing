package com.saucedemo.ui.components;

import net.serenitybdd.screenplay.targets.Target;

public class Error {

    private static final Target ERROR_MESSAGE_CONTAINER = Target.the("error message container").locatedBy("css:h3[data-test = 'error']");

    public static Target container() {
        return ERROR_MESSAGE_CONTAINER;
    }
}
