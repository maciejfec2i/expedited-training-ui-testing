package com.expeditedtraining.uitesting.user.tasks.tinymce;

import com.expeditedtraining.uitesting.ui.pages.theinternet.TinyMCETextEditorPage;
import com.expeditedtraining.uitesting.user.interactions.Click;
import com.expeditedtraining.uitesting.utils.data.ToolbarItemGroup;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import java.util.List;

public class TurnOff {

    public static Performable all(ToolbarItemGroup toolbarItemGroupFormatting) {
        return Task.where(
                "{0} clear(s) all applied " + toolbarItemGroupFormatting,
                actor -> {
                    List<WebElementFacade> toolbarButtons = BrowseTheWeb.as(actor).findAll(TinyMCETextEditorPage.TOOLBAR_ITEM_GROUP.of(toolbarItemGroupFormatting.name().toLowerCase()));

                    for(WebElementFacade toolbarButton : toolbarButtons) {
                        if(Boolean.parseBoolean(toolbarButton.getAttribute("aria-pressed"))) {
                            actor.attemptsTo(Click.on(toolbarButton));
                        }
                    }
                }
        );
    }
}
