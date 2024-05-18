package com.expeditedtraining.uitesting.user.tasks.tinymce;

import com.expeditedtraining.uitesting.ui.pages.theinternet.TinyMCETextEditorPage;
import com.expeditedtraining.uitesting.user.interactions.Click;
import com.expeditedtraining.uitesting.user.interactions.Hover;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Expand {

    public static Performable theStylesDropdown() {
        return Task.where(
                "{0} expand(s) the styles dropdown",
                Click.on(TinyMCETextEditorPage.STYLES_DROPDOWN),
                WaitUntil.the(ExpectedConditions.attributeToBe(TinyMCETextEditorPage.FORMATS_BTN, "aria-expanded", "true"))
        );
    }

    public static Performable theStylesDropdownSubmenuOf(String submenuName) {
        return Task.where(
                "{0} expand(s) the styles dropdown " + submenuName + " submenu",
                actor -> {
                    actor.attemptsTo(
                            Hover.over(TinyMCETextEditorPage.STYLES_MENU_ITEM.of(submenuName)),
                            WaitUntil.the(
                                    ExpectedConditions.attributeToBe(
                                            BrowseTheWeb
                                                    .as(actor)
                                                    .find(TinyMCETextEditorPage.STYLES_MENU_ITEM.of(submenuName)),
                                            "aria-expanded", "true")
                            )
                    );
                }
        );
    }
}
