package com.saucedemo.actor.questions;

import com.saucedemo.actor.questions.text.TextOfEachTarget;
import com.saucedemo.actor.questions.text.TextOfTarget;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Collection;

public class Text {

    public static Question<String> of(Target targetElement) {
        return Question.about("the text of the " + targetElement).answeredBy(new TextOfTarget(targetElement));
    }

    public static Question<Collection<String>> ofEach(Target targetElement) {
        return Question.about("the text of each " + targetElement).answeredBy(new TextOfEachTarget(targetElement));
    }
}
