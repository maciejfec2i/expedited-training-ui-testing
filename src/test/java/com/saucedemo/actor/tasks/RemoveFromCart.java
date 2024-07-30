package com.saucedemo.actor.tasks;

import com.saucedemo.actor.interactions.Click;
import com.saucedemo.ui.components.InventoryItem;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;

public class RemoveFromCart implements Performable, IsHidden {

    private final List<String> itemNames;

    public RemoveFromCart(List<String> itemNames) {
        this.itemNames = itemNames;
    }

    public static Performable theFollowing(String... items) {
        return Tasks.instrumented(RemoveFromCart.class, List.of(items));
    }

    public static Performable theFollowing(List<String> items) {
        return Tasks.instrumented(RemoveFromCart.class, items);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for(String itemName : itemNames) {
            actor.attemptsTo(Click.on(InventoryItem.REMOVE_FROM_CART_BUTTON.of(itemName)));
        }
    }
}
