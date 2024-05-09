package com.expeditedtraining.uitesting.user.actions.ui.base;

import com.expeditedtraining.uitesting.ui.pages.TinyMCETextEditorPage;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SwitchToTargetFrame implements Performable, IsHidden {

    private Target targetFrame;

    public SwitchToTargetFrame(Target targetFrame) {
        this.targetFrame = targetFrame;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ExpectedConditions.frameToBeAvailableAndSwitchToIt(BrowseTheWeb.as(actor)
                        .find(TinyMCETextEditorPage.RICH_TEXT_AREA_IFRAME)))
        );
    }
}
