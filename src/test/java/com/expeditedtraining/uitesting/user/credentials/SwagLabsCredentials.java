package com.expeditedtraining.uitesting.user.credentials;

public enum SwagLabsCredentials implements Credentials {

    STANDARD_USER("standard_user", "secret_sauce");

    private final String USERNAME;
    private final String PASSWORD;

    SwagLabsCredentials(String username, String password) {
        this.USERNAME = username;
        this.PASSWORD = password;
    }


    @Override
    public String getUsername() {
        return this.USERNAME;
    }

    @Override
    public String getPassword() {
        return this.PASSWORD;
    }
}
