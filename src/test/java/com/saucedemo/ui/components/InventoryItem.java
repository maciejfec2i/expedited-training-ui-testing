package com.saucedemo.ui.components;

import net.serenitybdd.screenplay.targets.Target;

public class InventoryItem {

    private static final Target INVENTORY_ITEM_NAME = Target.the("inventory item name").locatedBy("css:div[data-test='inventory-item-name']");
    private static final Target INVENTORY_ITEM_PRICE = Target.the("inventory item price").locatedBy("css:div[data-test='inventory-item-price']");
    private static final Target INVENTORY_ITEM_BUTTON = Target
            .the("{1} button of the {0} item card")
            .locatedBy("xpath://div[@data-test = 'inventory-item' and descendant::div[contains(normalize-space(), '{0}')]]//button[contains(normalize-space(), '{1}')]");

    public static Target componentBasedOn(String sortFilter) {
        String sortFilterName = sortFilter.toLowerCase();

        if(sortFilterName.toLowerCase().contains("name")) return INVENTORY_ITEM_NAME;
        else if(sortFilterName.toLowerCase().contains("price")) return INVENTORY_ITEM_PRICE;
        else throw new RuntimeException(String.format("%s is not a recognised sort filter", sortFilter));
    }

    public static Target addToCartButtonOf(String itemName) {
        return INVENTORY_ITEM_BUTTON.of(itemName, "Add to cart");
    }

    public static Target removeFromCartButtonOf(String itemName) {
        return INVENTORY_ITEM_BUTTON.of(itemName, "Remove");
    }

}
