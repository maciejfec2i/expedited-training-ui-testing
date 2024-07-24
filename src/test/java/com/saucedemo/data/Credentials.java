package com.saucedemo.data;

public enum Credentials {

    STANDARD_USER("standard_user", "secret_sauce"),
    LOCKED_OUT_USER("locked_out_user", "secret_sauce"),
    USER_WITH_INVALID_USERNAME("user_with_invalid_username", "secret_sauce"),
    USER_WITH_INVALID_PASSWORD("standard_user", "user_with_invalid_password");

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

    @Override
    public String toString() {
        return String.format("username: %s | password: %s", this.username, this.password);
    }
}
