package com.expeditedtraining.uitesting.user.tasks.theinternet;

import com.expeditedtraining.uitesting.ui.compontents.Button;
import com.expeditedtraining.uitesting.user.interactions.Click;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriggerJSPrompt implements Performable, IsHidden {

    private final Logger LOGGER = LoggerFactory.getLogger(TriggerJSPrompt.class);

    private final String promptType;

    public TriggerJSPrompt(String promptType) {
        this.promptType = promptType;
    }

    public static TriggerJSPrompt ofType(String promptType) {
        return new TriggerJSPrompt(promptType);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} attempts to trigger a {}", actor.getName(), promptType);

        actor.attemptsTo(Click.on(Button.WITH_TEXT.of("Click for " + this.promptType)));
    }
}
