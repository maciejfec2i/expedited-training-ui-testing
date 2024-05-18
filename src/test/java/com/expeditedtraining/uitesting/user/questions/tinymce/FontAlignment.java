package com.expeditedtraining.uitesting.user.questions.tinymce;

import com.expeditedtraining.uitesting.ui.pages.theinternet.TinyMCETextEditorPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Attribute;

public class FontAlignment {

    public static Question<String> ariaPressedAttributeFor(String alignment) {
        return Question.about("The state of the aria checked attribute of the " + alignment + " font alignment")
                .answeredBy(
                        actor -> actor.asksFor(Attribute.of(TinyMCETextEditorPage.TEXT_ALIGN_BUTTON.of(alignment), "aria-pressed"))
                );
    }
}
