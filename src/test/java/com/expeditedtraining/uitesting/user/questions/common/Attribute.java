package com.expeditedtraining.uitesting.user.questions.common;

import com.expeditedtraining.uitesting.user.questions.base.AttributeOfTarget;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class Attribute {

    public static Question<String> of(Target target, String attributeName) {
        return Question
                .about("The '" + attributeName +"' of the " + target)
                .answeredBy(new AttributeOfTarget(target, attributeName));
    }
}
