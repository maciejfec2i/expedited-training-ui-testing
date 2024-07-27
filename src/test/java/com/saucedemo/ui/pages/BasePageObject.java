package com.saucedemo.ui.pages;

import net.serenitybdd.core.pages.PageObject;

public class BasePageObject extends PageObject {

    @Override
    public String toString() {
        return String.join(" ", this.getClass().getSimpleName().split("(?=[A-Z])"));
    }
}
