package com.expeditedtraining.uitesting.user.questions.common;

import com.expeditedtraining.uitesting.user.questions.base.TextOfTarget;
import com.expeditedtraining.uitesting.user.questions.theinternet.TextOfAllRowValuesForColumn;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

public class Text {

    public static Question<String> of(Target target) {
        return Question
                .about("The text of the " + target)
                .answeredBy(new TextOfTarget(target));
    }

    public static Question<List<String>> ofAllRowValuesUnderColumn(String columnName) {
        return Question
                .about("The text of all the row values under the '" + columnName + "' column")
                .answeredBy(new TextOfAllRowValuesForColumn(columnName));
    }
}
