package com.expeditedtraining.uitesting.user.tasks.tinymce;

import com.expeditedtraining.uitesting.ui.pages.theinternet.TinyMCETextEditorPage;
import com.expeditedtraining.uitesting.user.interactions.Switch;
import com.expeditedtraining.uitesting.user.tasks.tinymce.ApplyTextEditor;
import com.expeditedtraining.uitesting.user.tasks.tinymce.Resize;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;

import java.util.List;
import java.util.Map;

public class Input {

    public static Performable contentIntoTextEditor(List<Map<String, String>> content) {
        return Task.where(
                "{0} enters content into the text editor with the specified formatting applied",
                actor -> {
                    actor.attemptsTo(
                            Resize.textEditor(),
                            Switch.toFrame(TinyMCETextEditorPage.RICH_TEXT_AREA_IFRAME),
                            Clear.field(TinyMCETextEditorPage.RICH_TEXT_AREA),
                            Switch.toDefaultContext()
                    );

                    for(Map<String, String> contentPiece : content) {
                        boolean isLastContentPiece = content.indexOf(contentPiece) == content.size() - 1;
                        String textToEnter = isLastContentPiece ? contentPiece.get("text") : contentPiece.get("text") + "\n";

                        actor.attemptsTo(
                                ApplyTextEditor.fontStyle(contentPiece.get("font-style")),
                                ApplyTextEditor.fontFormat(contentPiece.get("font-formatting")),
                                ApplyTextEditor.fontAlignment(contentPiece.get("font-alignment")),
                                Switch.toFrame(TinyMCETextEditorPage.RICH_TEXT_AREA_IFRAME),
                                Enter.keyValues(textToEnter).into(TinyMCETextEditorPage.RICH_TEXT_AREA),
                                Switch.toDefaultContext()
                        );
                    }
                }
        );
    }
}
