package com.expeditedtraining.uitesting.user.questions.swaglabs;

import com.expeditedtraining.uitesting.ui.compontents.ItemCard;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class NamesOfAllCartItems implements Question<List<String>> {

    private final Logger LOGGER = LoggerFactory.getLogger(NamesOfAllCartItems.class);

    @Override
    public List<String> answeredBy(Actor actor) {
        LOGGER.info("{} asks for the names of all the items in the cart", actor.getName());

        return BrowseTheWeb.as(actor).findAll(ItemCard.ITEM_NAME).textContents();
    }
}
