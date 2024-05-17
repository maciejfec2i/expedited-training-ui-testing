package com.expeditedtraining.uitesting.user.tasks.tinymce;

import com.expeditedtraining.uitesting.ui.pages.theinternet.TinyMCETextEditorPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Evaluate;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class Resize implements Performable {

    public static Resize textEditor() {
        return Tasks.instrumented(Resize.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TinyMCETextEditorPage.RESIZE_HANDLE, isVisible()),
                WaitUntil.the(TinyMCETextEditorPage.RESIZE_HANDLE, isClickable()),
                Evaluate.javascript(
                        String.format("arguments[0].style.height = '%s'", "400px"),
                        BrowseTheWeb.as(actor).find(By.cssSelector("div[role = 'application']"))
                )
        );
    }
}
