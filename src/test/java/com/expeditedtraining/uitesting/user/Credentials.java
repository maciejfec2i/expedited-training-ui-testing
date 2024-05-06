package com.expeditedtraining.uitesting.user;

public enum Credentials {

    STANDARD_USER("standard_user", "secret_sauce");

    private final String username;
    private final String password;

    Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String username() {
        return this.username;
    }

    public String password() {
        return this.password;
    }
}
