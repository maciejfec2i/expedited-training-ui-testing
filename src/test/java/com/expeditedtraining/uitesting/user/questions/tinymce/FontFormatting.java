package com.expeditedtraining.uitesting.user.questions.tinymce;

import com.expeditedtraining.uitesting.ui.pages.theinternet.TinyMCETextEditorPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Attribute;

public class FontFormatting {

    public static Question<String> ariaPressedAttributeFor(String format) {
        return Question.about("The state of the aria checked attribute of the " + format + " font format")
                .answeredBy(
                        actor -> actor.asksFor(Attribute.of(TinyMCETextEditorPage.TEXT_FORMAT_BUTTON.of(format), "aria-pressed"))
                );
    }
}
