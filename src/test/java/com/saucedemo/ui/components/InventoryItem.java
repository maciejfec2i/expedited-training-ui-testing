package com.saucedemo.ui.components;

import net.serenitybdd.screenplay.targets.Target;

public class InventoryItem {

    private static final Target INVENTORY_ITEM_NAME = Target.the("inventory item name").locatedBy("css:div[data-test='inventory-item-name']");
    private static final Target INVENTORY_ITEM_PRICE = Target.the("inventory item price").locatedBy("css:div[data-test='inventory-item-price']");

    public static Target componentBasedOn(String sortFilter) {
        String sortFilterName = sortFilter.toLowerCase();

        if(sortFilterName.toLowerCase().contains("name")) return INVENTORY_ITEM_NAME;
        else if(sortFilterName.toLowerCase().contains("price")) return INVENTORY_ITEM_PRICE;
        else throw new RuntimeException(String.format("%s is not a recognised sort filter", sortFilter));
    }
}
