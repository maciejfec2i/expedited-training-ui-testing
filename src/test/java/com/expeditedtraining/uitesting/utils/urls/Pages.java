package com.expeditedtraining.uitesting.utils.urls;

public enum Pages {

    TABLES(BaseURLs.THE_INTERNET, "/tables");

    private final String pageUrl;

    Pages(BaseURLs baseURL, String pageEndpoint) {
        this.pageUrl = baseURL + pageEndpoint;
    }

    public String getPageUrl() {
        return this.pageUrl;
    }
}
