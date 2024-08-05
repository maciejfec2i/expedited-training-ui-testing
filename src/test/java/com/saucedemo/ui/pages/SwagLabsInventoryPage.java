package com.saucedemo.ui.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.util.List;
import java.util.function.Function;

@DefaultUrl("swag.labs.inventory.page.url")
public class SwagLabsInventoryPage extends BasePageObject {

    public static final Target PRODUCT_SORT_DROPDOWN = Target
            .the("product sort dropdown")
            .locatedBy("css:select[data-test = 'product-sort-container']");

    private final Function <String, String> ITEM_CARD_LOCATOR_FOR_ITEM = itemName -> String.format(
            "//div[@data-test = 'inventory-item' and descendant::div[contains(normalize-space(), '%s')]]", itemName
    );
    private final Function<String, By> ADD_TO_CART_BUTTON_FOR_ITEM = itemName -> By.xpath(
            String.format("%s//button[contains(normalize-space(), 'Add to cart')]", ITEM_CARD_LOCATOR_FOR_ITEM.apply(itemName))
    );

    private final Function<String, By> REMOVE_FROM_CART_BUTTON_FOR_ITEM = itemName -> By.xpath(
            String.format("%s//button[contains(normalize-space(), 'Remove')]", ITEM_CARD_LOCATOR_FOR_ITEM.apply(itemName))
    );

    public void addToCartTheFollowing(List<String> items) {
        for(String itemName : items) {
            clickOnTheElementLocatedBy(ADD_TO_CART_BUTTON_FOR_ITEM.apply(itemName));
        }
    }

    public void removeFromCartTheFollowing(List<String> items) {
        for(String itemName : items) {
            clickOnTheElementLocatedBy(REMOVE_FROM_CART_BUTTON_FOR_ITEM.apply(itemName));
        }
    }
}
