package com.expeditedtraining.uitesting.user.tasks.swaglabs.cart;

import com.expeditedtraining.uitesting.ui.compontents.ItemCard;
import com.expeditedtraining.uitesting.user.interactions.Click;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.util.List;

public class RemoveFromCart {

    public static Performable itemsCalled(List<String> itemNames) {
        return Task.where(
                "{0} remove(s) the following items from the cart: " + itemNames,
                actor -> {
                    for(String itemName : itemNames) {
                        actor.attemptsTo(Click.on(ItemCard.REMOVE_ITEM_BTN.of(itemName)));
                    }
                }
        );
    }
}
