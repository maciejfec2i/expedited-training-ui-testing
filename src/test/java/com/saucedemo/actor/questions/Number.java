package com.saucedemo.actor.questions;

import com.google.common.base.Strings;
import com.saucedemo.ui.components.InventoryItem;
import com.saucedemo.ui.components.ShoppingCart;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Number {

    private static final Logger LOGGER = LoggerFactory.getLogger(Number.class);

    public static Question<Integer> ofItemsDisplayedOnTheShoppingCartBadge() {
        return Question
                .about("number of items displayed on the shopping cart badge")
                .answeredBy(actor -> {
                    LOGGER.info("{} asks for the number of items displayed on the shopping cart badge", actor.getName());
                    String shoppingCartNumberOfItems = actor.asksFor(Text.of(ShoppingCart.LINK));
                    return Strings.isNullOrEmpty(shoppingCartNumberOfItems) ? 0 : Integer.parseInt(shoppingCartNumberOfItems);
                });
    }

    public static Question<Integer> ofItemsInTheCart() {
        return Question
                .about("number of items displayed in the cart")
                .answeredBy(
                        actor -> {
                            LOGGER.info("{} asks for the number of items displayed in the cart", actor.getName());
                            return InventoryItem.CARD.resolveAllFor(actor).size();
                        }
                );
    }
}
