package com.saucedemo.data;

/**
 * Centralised location for storing page titles of the different pages that compose the Swag Labs site. Allows for making
 * updates in a single place if the UI text updates at any point.
 */
public enum PageTitleText {

    SWAG_LABS_INVENTORY_PAGE("Products");

    private final String content;

    PageTitleText(String content) {
        this.content = content;
    }

    public String content() {
        return this.content;
    }
}
