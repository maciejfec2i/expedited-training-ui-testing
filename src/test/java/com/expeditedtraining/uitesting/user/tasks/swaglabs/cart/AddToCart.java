package com.expeditedtraining.uitesting.user.tasks.swaglabs.cart;

import com.expeditedtraining.uitesting.utils.ItemNameToIDMapper;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Evaluate;

import java.util.List;

public class AddToCart {

    public static Performable itemsCalled(List<String> itemNames) {
        return Task.where(
                "{0} add(s) the following items to the cart: " + itemNames,
                actor -> {
                    List<String> itemNamesAsIDs = ItemNameToIDMapper.map(itemNames);
                    String script = String.format("localStorage.setItem('cart-contents', '%s');", itemNamesAsIDs);

                    actor.attemptsTo(
                            Evaluate.javascript(script)
                    );
                }
        );
    }
}
