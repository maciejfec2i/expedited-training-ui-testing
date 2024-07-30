package com.saucedemo.actor.questions.text;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Question for retrieving the text of the specified target element.
 */
public class TextOfTarget implements Question<String> {

    private final Logger LOGGER = LoggerFactory.getLogger(TextOfTarget.class);

    private final Target targetElement;

    public TextOfTarget(Target targetElement) {
        this.targetElement = targetElement;
    }

    @Override
    public String answeredBy(Actor actor) {
        LOGGER.info("{} asks for the text of the {}", actor.getName(), targetElement);

        return Text.of(targetElement).answeredBy(actor);
    }
}
