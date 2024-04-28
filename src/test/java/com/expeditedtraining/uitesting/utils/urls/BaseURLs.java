package com.expeditedtraining.uitesting.utils.urls;

public enum BaseURLs {

    THE_INTERNET("https://the-internet.herokuapp.com");

    private final String url;

    BaseURLs(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
}
