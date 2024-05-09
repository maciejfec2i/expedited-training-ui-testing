package com.expeditedtraining.uitesting.ui.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TinyMCETextEditorPage {

    public static final By FORMATS_BTN = By.cssSelector("button[title = 'Formats']");
    public static final Target STYLES_DROPDOWN = Target.the("Text styles dropdown").located(By.cssSelector("div[title = 'styles']"));
    public static final Target STYLES_MENU_ITEM = Target.the("Styles for {0}").locatedBy("//div[@title = '{0}']");
    public static final Target TOOLBAR_ITEM_GROUP = Target.the("Toolbar items for '{0}'").locatedBy("//div[@title = '{0}']//button");
    public static final Target TEXT_FORMAT_BUTTON = Target.the("'{0}' text format").locatedBy("//div[@title= 'formatting']//button[@title = '{0}']");
    public static final Target TEXT_ALIGN_BUTTON = Target.the("'{0}' text alignment").locatedBy("//div[@title= 'alignment']//button[@title = '{0}']");
    public static final Target RICH_TEXT_AREA_IFRAME = Target.the("Rich Text Area iFrame").located(By.cssSelector("iframe[title = 'Rich Text Area']"));
    public static final Target RICH_TEXT_AREA = Target.the("Rich Text Area").located(By.cssSelector("body[aria-label *= 'Rich Text Area']"));
    public static final Target RESIZE_HANDLE = Target.the("Resize handle").located(By.cssSelector("div[title = 'Resize']"));

    public static Target richTextAreaContentSectionWithTextOf(String contentSectionText) {
        return RICH_TEXT_AREA.find(
                Target
                        .the("Content section")
                        .locatedBy(String.format("//*[normalize-space() = '%s']", contentSectionText))
        );
    }
}
