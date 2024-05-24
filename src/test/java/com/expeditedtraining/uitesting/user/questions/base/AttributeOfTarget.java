package com.expeditedtraining.uitesting.user.questions.base;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Attribute;
import net.serenitybdd.screenplay.targets.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The purpose of this class is to retrieve the specified attribute of the provided {@link Target} instance element.
 * This class is a Serenity BDD {@link Question} for asserting and/or retrieving information.
 *
 * @author Maciej Fec
 * @version 20/05/2024
 */
public class AttributeOfTarget implements Question<String> {

    private final Logger LOGGER = LoggerFactory.getLogger(AttributeOfTarget.class);

    private final Target target;
    private final String attributeName;

    public AttributeOfTarget(Target target, String attributeName) {
        this.target = target;
        this.attributeName = attributeName;
    }

    @Override
    public String answeredBy(Actor actor) {
        LOGGER.info("{} asks for the '{}' attribute of the {}", actor.getName(), attributeName, target);

        return actor.asksFor(Attribute.of(target, attributeName));
    }
}
