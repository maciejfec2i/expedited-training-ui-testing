package com.saucedemo.ui.components;

import net.serenitybdd.screenplay.targets.Target;

public class SelectOption {

    private static final Target SELECT_OPTION_CONTAINING_TEXT = Target
            .the("Select option containing '{0}'")
            .locatedBy("//option[contains(normalize-space(), '{0}')]");

    public static Target containingText(String optionText) {
        return SELECT_OPTION_CONTAINING_TEXT.of(optionText);
    }
}
