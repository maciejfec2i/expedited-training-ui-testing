package com.expeditedtraining.uitesting.user.questions.base;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Attribute;
import net.serenitybdd.screenplay.targets.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
