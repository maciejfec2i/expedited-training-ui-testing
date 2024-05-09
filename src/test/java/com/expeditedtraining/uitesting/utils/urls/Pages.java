package com.expeditedtraining.uitesting.utils.urls;

public enum Pages {

    TABLES(BaseURLs.THE_INTERNET.getUrl(), "/tables"),
    JAVASCRIPT_ALERTS(BaseURLs.THE_INTERNET.getUrl(), "/javascript_alerts"),
    WINDOWS_LINKS_AND_EXAMPLES(BaseURLs.TEST_PAGES.getUrl(), "/styled/windows-test.html"),
    DRAG_AND_DROP(BaseURLs.THE_INTERNET.getUrl(), "/drag_and_drop"),
    SWAG_LABS_LOGIN(BaseURLs.SWAG_LABS.getUrl(), "/"),
    SWAG_LABS_INVENTORY(BaseURLs.SWAG_LABS.getUrl(), "/inventory.html"),
    SWAG_LABS_CART(BaseURLs.SWAG_LABS.getUrl(), "/cart.html"),
    TINYMCE(BaseURLs.THE_INTERNET.getUrl(), "/tinymce");

    private final String pageUrl;

    Pages(String baseURL, String pageEndpoint) {
        this.pageUrl = baseURL + pageEndpoint;
    }

    public String getPageUrl() {
        return this.pageUrl;
    }
}
