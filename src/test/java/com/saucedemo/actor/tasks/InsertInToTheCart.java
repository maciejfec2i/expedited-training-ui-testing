package com.saucedemo.actor.tasks;

import com.saucedemo.data.InventoryItem;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class InsertInToTheCart implements Performable {

    private final Logger LOGGER = LoggerFactory.getLogger(InsertInToTheCart.class);

    private final List<String> itemNames;

    public InsertInToTheCart(List<String> itemNames) {
        this.itemNames = itemNames;
    }

    public static Performable theFollowing(String... items) {
        return Tasks.instrumented(InsertInToTheCart.class, List.of(items));
    }

    public static Performable theFollowing(List<String> items) {
        return Tasks.instrumented(InsertInToTheCart.class, items);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Integer> itemsIds = new ArrayList<>();

        for(String itemName : itemNames) {
            itemsIds.add(
                    InventoryItem.valueOf(
                            itemName
                                    .replace(" ", "_")
                                    .replaceAll("[^a-zA-Z0-9_]", "")
                                    .toUpperCase()
                    ).getId()
            );
        }

        String script = String.format("localStorage.setItem('cart-contents', '%s');", itemsIds);
        BrowseTheWeb.as(actor).evaluateJavascript(script);
    }
}
