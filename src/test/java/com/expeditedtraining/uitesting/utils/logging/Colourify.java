package com.expeditedtraining.uitesting.utils.logging;

public class Colourify {

    private final String text;
    private final String colouredText = "\u001B[%s%s\u001B[0m";

    public Colourify(String text) {
        this.text = text;
    }

    public static Colourify theText(String text) {
        return new Colourify(text);
    }

    public String with(Colour colour) {
        return String.format(this.colouredText, colour.getColourCode(), this.text);
    }
}
