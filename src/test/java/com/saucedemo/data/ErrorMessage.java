package com.saucedemo.data;

/**
 * Centralised location for storing the different error messages that the Swag Labs site displays. Allows for making
 * updates in a single place if the UI text updates at any point.
 */
public enum ErrorMessage {

    LOCKED_OUT("Sorry, this user has been locked out"),
    INVALID_CREDENTIALS("Username and password do not match any user in this service");

    private final String text;

    ErrorMessage(String text) {
        this.text = text;
    }

    public String text() {
        return this.text;
    }
}
