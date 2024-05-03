package com.expeditedtraining.uitesting.utils.urls;

public enum Pages {

    TABLES(BaseURLs.THE_INTERNET.getUrl(), "/tables"),
    JAVASCRIPT_ALERTS(BaseURLs.THE_INTERNET.getUrl(), "/javascript_alerts"),
    WINDOWS_LINKS_AND_EXAMPLES(BaseURLs.TEST_PAGES.getUrl(), "/styled/windows-test.html");

    private final String pageUrl;

    Pages(String baseURL, String pageEndpoint) {
        this.pageUrl = baseURL + pageEndpoint;
    }

    public String getPageUrl() {
        return this.pageUrl;
    }
}
