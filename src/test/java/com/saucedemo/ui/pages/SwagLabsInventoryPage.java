package com.saucedemo.ui.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("swag.labs.inventory.page.url")
public class SwagLabsInventoryPage extends BasePageObject {

    public static final Target PRODUCT_SORT_DROPDOWN = Target
            .the("product sort dropdown")
            .locatedBy("css:select[data-test = 'product-sort-container']");
}
