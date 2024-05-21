package com.expeditedtraining.uitesting.user.tasks.tinymce;

import com.expeditedtraining.uitesting.ui.pages.theinternet.TinyMCETextEditorPage;
import com.expeditedtraining.uitesting.user.interactions.Click;
import com.expeditedtraining.uitesting.utils.data.ToolbarItemGroup;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.util.List;

public class ApplyTextEditor {

    public static Performable fontStyle(String style) {
        return Task.where(
                actor -> {
                    List<String> fontStyleFamilyMembers = List.of(style.split(" > "));

                    actor.attemptsTo(Expand.theStylesDropdown());

                    for(String fontStyleFamilyMember : fontStyleFamilyMembers) {
                        if(fontStyleFamilyMembers.indexOf(fontStyleFamilyMember) == fontStyleFamilyMembers.size() - 1) {
                            actor.attemptsTo(Click.on(TinyMCETextEditorPage.STYLES_MENU_ITEM.of(fontStyleFamilyMember)));
                            break;
                        }

                        actor.attemptsTo(Expand.theStylesDropdownSubmenuOf(fontStyleFamilyMember));
                    }
                }
        );
    }

    public static Performable fontFormat(String format) {
        return Task.where(
                actor -> {
                    actor.attemptsTo(TurnOff.allActiveItemsFrom(ToolbarItemGroup.FORMATTING));

                    if(!format.equalsIgnoreCase("normal")) {
                        actor.attemptsTo(Click.on(TinyMCETextEditorPage.TEXT_FORMAT_BUTTON.of(format)));
                    }
                }
        );
    }

    public static Performable fontAlignment(String alignment) {
        return Task.where(
                TurnOff.allActiveItemsFrom(ToolbarItemGroup.ALIGNMENT),
                Click.on(TinyMCETextEditorPage.TEXT_ALIGN_BUTTON.of(alignment))
        );
    }
}
