package com.automationexercise.utilities.data;

public enum Countries {
    INDIA("India", "en-IND"),
    UNITED_STATES("United States", "en-US"),
    CANADA("Canada", "en-CA"),
    AUSTRALIA("Australia", "en-AU"),
    NEW_ZEALAND("New Zealand", "en-NZ"),
    SINGAPORE("Singapore", "en-SG");

    private final String name;
    private final String localeCode;

    Countries(String name, String localeCode) {
        this.name = name;
        this.localeCode = localeCode;
    }

    public String getName() {
        return this.name;
    }

    public String getLocaleCode() {
        return this.localeCode;
    }
}
