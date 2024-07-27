package com.saucedemo.ui.components;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

/**
 * Component to target the element that is considered the page title by the Swag Labs Site.
 */
public class PageTitle {

    private static final Target PAGE_TITLE = Target.the("page title of the {0}").locatedBy("css:span[data-test = 'title']");

    public static Target of(PageObject page) {
        return PAGE_TITLE.of(page.toString());
    }

    public static Target ofTheCurrentPage() {
        return PAGE_TITLE.of("current page");
    }
}
