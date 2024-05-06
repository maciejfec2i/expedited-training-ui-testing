package com.expeditedtraining.uitesting.user.actions.api;

import com.expeditedtraining.uitesting.utils.ItemNameToIDMapper;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Evaluate;

import java.util.List;

public class UseCartAPI {

    public static Performable toAddItems(List<String> itemNames) {
        return Task.where(
                "{0} adds the following items to the cart: " + itemNames,
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
