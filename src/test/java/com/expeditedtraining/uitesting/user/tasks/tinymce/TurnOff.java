package com.expeditedtraining.uitesting.user.tasks.tinymce;

import com.expeditedtraining.uitesting.ui.pages.theinternet.TinyMCETextEditorPage;
import com.expeditedtraining.uitesting.user.interactions.Click;
import com.expeditedtraining.uitesting.utils.data.ToolbarItemGroup;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import java.util.List;

public class TurnOff {

    public static Performable allActiveItemsFrom(ToolbarItemGroup toolbarItemGroup) {
        return Task.where(
                "{0} clear(s) all active items from " + toolbarItemGroup,
                Tasks.instrumented(TurnOffAllActiveToolBarItemsFromGroup.class, toolbarItemGroup)
        );
    }
}
