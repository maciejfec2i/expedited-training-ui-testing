package com.expeditedtraining.uitesting.stepdefinitions;

import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class ParameterDefinitions {

    @ParameterType(".*")
    public Actor user(String userType) {
        return OnStage.theActorCalled(userType);
    }

    @ParameterType(".*")
    public Performable promptAction(String promptAction) {
        List<String> actionsToPerform = List.of(promptAction.split(";"));
        ArrayList<Performable> performableActions = new ArrayList<>();
        performableActions.add(
                WaitUntil.the(ExpectedConditions.alertIsPresent())
        );

        for(String action : actionsToPerform) {
            List<String> actionAndType = List.of(action.split(":"));
            switch(actionAndType.get(0).toLowerCase()) {
                case "click":
                    if(actionAndType.get(1).equalsIgnoreCase("ok")) performableActions.add(Switch.toAlert().andAccept());
                    else if(actionAndType.get(1).equalsIgnoreCase("cancel")) performableActions.add(Switch.toAlert().andDismiss());
                    break;
                case "type":
                    performableActions.add(
                            Task.where(actor -> {
                                String textToType = actionAndType.get(1);
                                BrowseTheWeb.as(actor).getAlert().sendKeys(textToType);
                            })
                    );
                    break;
                default: throw new IllegalArgumentException(String.format("'%s' is not a prompt executable action", action));
            }
        }

        return Task.where(
                performableActions.toArray(new Performable[0])
        );
    }
}
