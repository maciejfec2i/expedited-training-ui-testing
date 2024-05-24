package com.expeditedtraining.uitesting.user.tasks.tinymce;

import com.expeditedtraining.uitesting.ui.pages.theinternet.TinyMCETextEditorPage;
import com.expeditedtraining.uitesting.user.interactions.Click;
import com.expeditedtraining.uitesting.utils.data.ToolbarItemGroup;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class TurnOffAllActiveToolBarItemsFromGroup implements Performable {

    private final Logger LOGGER = LoggerFactory.getLogger(TurnOffAllActiveToolBarItemsFromGroup.class);

    private final ToolbarItemGroup toolbarItemGroup;

    public TurnOffAllActiveToolBarItemsFromGroup(ToolbarItemGroup toolbarItemGroup) {
        this.toolbarItemGroup = toolbarItemGroup;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} attempts to turn off all active toolbar items for {}", actor.getName(), toolbarItemGroup.name());

        Target targetToolbarButton = TinyMCETextEditorPage.TOOLBAR_ITEM_GROUP.of(toolbarItemGroup.name().toLowerCase());

        actor.attemptsTo(WaitUntil.the(targetToolbarButton, isVisible()));

        List<WebElementFacade> toolbarButtons = BrowseTheWeb.as(actor).findAll(targetToolbarButton);

        for(WebElementFacade toolbarButton : toolbarButtons) {
            if(Boolean.parseBoolean(toolbarButton.getAttribute("aria-pressed"))) {
                actor.attemptsTo(Click.on(toolbarButton));
            }
        }
    }
}
