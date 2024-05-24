package com.expeditedtraining.uitesting.user.questions.common;

import com.expeditedtraining.uitesting.user.questions.base.NumberOfOpenBrowserTabs;
import net.serenitybdd.screenplay.Question;

public class Number {

    public static Question<Integer> ofOpenBrowserTabs() {
        return Question.about("The number of open tabs").answeredBy(new NumberOfOpenBrowserTabs());
    }
}
