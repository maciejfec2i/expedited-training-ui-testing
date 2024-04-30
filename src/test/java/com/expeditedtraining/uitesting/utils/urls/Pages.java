package com.expeditedtraining.uitesting.utils.urls;

public enum Pages {

    TABLES(BaseURLs.THE_INTERNET.getUrl(), "/tables"),
    JAVASCRIPT_ALERTS(BaseURLs.THE_INTERNET.getUrl(), "/javascript_alerts");

    private final String pageUrl;

    Pages(String baseURL, String pageEndpoint) {
        this.pageUrl = baseURL + pageEndpoint;
    }

    public String getPageUrl() {
        return this.pageUrl;
    }
}
