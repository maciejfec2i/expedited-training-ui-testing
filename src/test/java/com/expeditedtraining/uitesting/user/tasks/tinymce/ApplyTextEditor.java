package com.expeditedtraining.uitesting.user.tasks.tinymce;

import com.expeditedtraining.uitesting.ui.pages.theinternet.TinyMCETextEditorPage;
import com.expeditedtraining.uitesting.user.interactions.Click;
import com.expeditedtraining.uitesting.user.interactions.Hover;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ApplyTextEditor {

    public static Performable fontStyle(String style) {
        return Task.where(
                actor -> {
                    List<String> fontStyleFamilyMembers = List.of(style.split(" > "));

                    actor.attemptsTo(
                            Click.on(TinyMCETextEditorPage.STYLES_DROPDOWN),
                            WaitUntil.the(ExpectedConditions.attributeToBe(TinyMCETextEditorPage.FORMATS_BTN, "aria-expanded", "true"))
                    );

                    for(String fontStyleFamilyMember : fontStyleFamilyMembers) {
                        if(fontStyleFamilyMembers.indexOf(fontStyleFamilyMember) == fontStyleFamilyMembers.size() - 1) {
                            actor.attemptsTo(Click.on(TinyMCETextEditorPage.STYLES_MENU_ITEM.of(fontStyleFamilyMember)));
                            break;
                        }

                        actor.attemptsTo(
                                Hover.over(TinyMCETextEditorPage.STYLES_MENU_ITEM.of(fontStyleFamilyMember)),
                                WaitUntil.the(
                                        ExpectedConditions.attributeToBe(
                                                BrowseTheWeb
                                                        .as(actor)
                                                        .find(TinyMCETextEditorPage.STYLES_MENU_ITEM.of(fontStyleFamilyMember)),
                                                "aria-expanded",
                                                "true"
                                        )
                                )
                        );
                    }
                }
        );
    }

    public static Performable fontFormat(String format) {
        return Task.where(
                actor -> {
                    actor.attemptsTo(clearAll("formatting"));

                    if(!format.equalsIgnoreCase("normal")) {
                        actor.attemptsTo(Click.on(TinyMCETextEditorPage.TEXT_FORMAT_BUTTON.of(format)));
                    }
                }
        );
    }

    public static Performable fontAlignment(String alignment) {
        return Task.where(
                ApplyTextEditor.clearAll("alignment"),
                Click.on(TinyMCETextEditorPage.TEXT_ALIGN_BUTTON.of(alignment))
        );
    }

    public static Performable clearAll(String toolbarItemGroup) {
        return Task.where(
                actor -> {
                    List<WebElementFacade> toolbarButtons = BrowseTheWeb.as(actor).findAll(TinyMCETextEditorPage.TOOLBAR_ITEM_GROUP.of(toolbarItemGroup));

                    for(WebElementFacade toolbarButton : toolbarButtons) {
                        if(Boolean.parseBoolean(toolbarButton.getAttribute("aria-pressed"))) {
                            actor.attemptsTo(Click.on(toolbarButton));
                        }
                    }
                }
        );
    }
}
