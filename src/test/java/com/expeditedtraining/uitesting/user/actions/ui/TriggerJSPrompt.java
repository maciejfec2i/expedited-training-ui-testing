package com.expeditedtraining.uitesting.user.actions.ui;

import com.expeditedtraining.uitesting.ui.compontents.Button;
import com.expeditedtraining.uitesting.user.actions.ui.base.ClickOn;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;

public class TriggerJSPrompt implements Performable, IsHidden {

    private final String promptType;

    public TriggerJSPrompt(String promptType) {
        this.promptType = promptType;
    }

    public static TriggerJSPrompt ofType(String promptType) {
        return new TriggerJSPrompt(promptType);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(Button.WITH_TEXT.of("Click for " + this.promptType))
        );
    }
}
