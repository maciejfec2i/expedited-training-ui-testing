package com.saucedemo.actor.questions;

import com.saucedemo.actor.questions.url.UrlOfCurrentPage;
import com.saucedemo.actor.questions.url.UrlOfPageObject;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Question;

public class Url {

    public static Question<String> of(PageObject pageObject) {
        return Question
                .about("The URL of " + pageObject.getClass().getSimpleName())
                .answeredBy(new UrlOfPageObject(pageObject));
    }

    public static Question<String> ofTheCurrentlyOpenPage() {
        return Question.about("The URL of the currently open page").answeredBy(new UrlOfCurrentPage());
    }
}
