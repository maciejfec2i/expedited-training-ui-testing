package com.expeditedtraining.uitesting.user.questions.base;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The purpose of this class is to retrieve the text of the provided {@link Target} instance element.
 * This class is a Serenity BDD {@link Question} for asserting and/or retrieving information.
 *
 * @author Maciej Fec
 * @version 20/05/2024
 */
public class TextOfTarget implements Question<String> {

    private final Logger LOGGER = LoggerFactory.getLogger(TextOfTarget.class);

    private final Target target;

    public TextOfTarget(Target target) {
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor) {
        LOGGER.info("{} asks for the text of the {}", actor.getName(), target);

        return actor.asksFor(Text.of(target));
    }
}
