package com.expeditedtraining.uitesting.ui.compontents;

import net.serenitybdd.screenplay.targets.Target;

public class ItemCard {

    public static final Target REMOVE_ITEM_BTN = Target.the("Remove button on {0} item card")
            .locatedBy("//div[@data-test='inventory-item' and contains(normalize-space(), '{0}')]//button[contains(@data-test, 'remove')]");

    public static final Target ITEM_NAME = Target.the("Item Name").locatedBy("//div[@data-test = 'inventory-item-name']");
}
