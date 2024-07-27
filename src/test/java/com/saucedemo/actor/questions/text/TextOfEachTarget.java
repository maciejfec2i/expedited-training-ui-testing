package com.saucedemo.actor.questions.text;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class TextOfEachTarget implements Question<Collection<String>> {

    private final Logger LOGGER = LoggerFactory.getLogger(TextOfEachTarget.class);

    private final Target targetElement;

    public TextOfEachTarget(Target targetElement) {
        this.targetElement = targetElement;
    }

    @Override
    public Collection<String> answeredBy(Actor actor) {
        LOGGER.info("{} asks for the text of each {}", actor.getName(), targetElement);

        return Text.ofEach(targetElement).answeredBy(actor);
    }
}
