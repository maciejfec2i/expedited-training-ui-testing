package com.expeditedtraining.uitesting.user.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

public class IDAttribute {

    public static Question<String> of(Target target) {
        return Question
                .about("The ID attribute of " + target)
                .answeredBy(
                        actor -> BrowseTheWeb.as(actor).find(target).getAttribute("id")
                );
    }
}
