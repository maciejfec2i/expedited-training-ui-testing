package com.saucedemo.ui.components;

import net.serenitybdd.screenplay.targets.Target;

public class InventoryItem {

    private static final String INVENTORY_ITEM_CARD_OF = "//div[@data-test = 'inventory-item' and descendant::div[contains(normalize-space(), '{0}')]]";

    public final static Target CARD = Target.the("inventory item card").locatedBy("css:div[data-test = 'inventory-item']");
    public static final Target NAME = Target.the("inventory item name").locatedBy("css:div[data-test='inventory-item-name']");
    public static final Target PRICE = Target.the("inventory item price").locatedBy("css:div[data-test='inventory-item-price']");
    public static final Target ADD_TO_CART_BUTTON = Target.the("Add to cart button on the {0} item card").locatedBy(INVENTORY_ITEM_CARD_OF + "//button[contains(normalize-space(), 'Add to cart')]");
    public static final Target REMOVE_FROM_CART_BUTTON = Target.the("Remove button on the {0} item card").locatedBy(INVENTORY_ITEM_CARD_OF + "//button[contains(normalize-space(), 'Remove')]");


    public static Target componentBasedOn(String sortFilter) {
        String sortFilterName = sortFilter.toLowerCase();

        if(sortFilterName.toLowerCase().contains("name")) return NAME;
        else if(sortFilterName.toLowerCase().contains("price")) return PRICE;
        else throw new RuntimeException(String.format("%s is not a recognised sort filter", sortFilter));
    }

    public static Target cardOf(String itemName) {
        return Target.the("inventory item card of {0}").locatedBy(INVENTORY_ITEM_CARD_OF).of(itemName);
    }
}
