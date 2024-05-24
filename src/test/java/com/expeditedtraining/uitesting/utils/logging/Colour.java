package com.expeditedtraining.uitesting.utils.logging;

public enum Colour {

    BLACK("30m"),
    BLUE("34m"),
    CYAN("36m"),
    GREEN("32m"),
    MAGENTA("35m"),
    RED("31m"),
    YELLOW("33m"),
    WHITE("37m");

    private final String colourCode;

    Colour(String colourCode) {
        this.colourCode = colourCode;
    }

    public String getColourCode() {
        return this.colourCode;
    }
}
