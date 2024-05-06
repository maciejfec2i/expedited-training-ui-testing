package com.expeditedtraining.uitesting.user.actions.ui;

import com.expeditedtraining.uitesting.ui.compontents.ItemCard;
import com.expeditedtraining.uitesting.user.actions.ui.base.ClickOn;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.util.List;

public class RemoveCartItems {

    public static Performable called(List<String> itemNames) {
        return Task.where(
                "{0} removes the following items from the cart: " + itemNames,
                actor -> {
                    for(String itemName : itemNames) {
                        actor.attemptsTo(ClickOn.the(ItemCard.REMOVE_ITEM_BTN.of(itemName)));
                    }
                }
        );
    }
}
