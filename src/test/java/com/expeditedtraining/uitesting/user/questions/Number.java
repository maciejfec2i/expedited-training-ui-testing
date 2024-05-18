package com.expeditedtraining.uitesting.user.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class NumberOf {

    public static Question<Integer> openTabs() {
        return Question.about("The number of open tabs").answeredBy(actor -> BrowseTheWeb.as(actor).getDriver().getWindowHandles().size());
    }
}
