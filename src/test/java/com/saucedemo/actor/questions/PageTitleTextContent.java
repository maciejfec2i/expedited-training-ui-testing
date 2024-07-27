package com.saucedemo.actor.questions;

import com.saucedemo.data.PageTitleText;
import net.serenitybdd.core.pages.PageObject;

/**
 * Question for grabbing the page title text content out of the {@link PageTitleText} enum.
 */
public class PageTitleTextContent {

    /**
     * This method grabs the text content from the {@link PageTitleText} enum.
     *
     * @param page The {@link PageObject} for which title text content is to be retrieved. The class name of the
     *             provided {@link PageObject} should match an enum constant value name within the {@link PageTitleText}
     *             enum.
     * @return {@link String} instance of the page title text content.
     */
    public static String of(PageObject page) {
        return PageTitleText.valueOf(page.toString().toUpperCase().replace(" ", "_")).content();
    }
}
