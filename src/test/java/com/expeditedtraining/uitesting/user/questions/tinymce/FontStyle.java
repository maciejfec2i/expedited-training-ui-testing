package com.expeditedtraining.uitesting.user.questions.tinymce;

import com.expeditedtraining.uitesting.ui.pages.theinternet.TinyMCETextEditorPage;
import com.expeditedtraining.uitesting.user.tasks.tinymce.Expand;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Attribute;

import java.util.List;

public class FontStyle {

    public static Question<String> ariaCheckedAttributeFor(String style) {
        return Question.about("The state of the aria checked attribute of the " + style + " font style")
                .answeredBy(
                        actor -> {
                            List<String> fontStyleFamilyMembers = List.of(style.split(" > "));

                            actor.attemptsTo(Expand.theStylesDropdown());

                            for(String fontStyleFamilyMember : fontStyleFamilyMembers) {
                                if(fontStyleFamilyMembers.indexOf(fontStyleFamilyMember) == fontStyleFamilyMembers.size() - 1) {
                                    return actor.asksFor(Attribute.of(TinyMCETextEditorPage.STYLES_MENU_ITEM.of(fontStyleFamilyMember), "aria-checked"));
                                }

                                actor.attemptsTo(Expand.theStylesDropdownSubmenuOf(fontStyleFamilyMember));
                            }

                            return "false";
                        }
                );
    }
}
