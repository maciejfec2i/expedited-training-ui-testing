package com.expeditedtraining.uitesting.user.questions;

import com.expeditedtraining.uitesting.ui.compontents.ItemCard;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import java.util.List;

public class Cart {

    public static Question<List<String>> items() {
        return Question.about("Names of all items in the cart").answeredBy(
                actor -> BrowseTheWeb.as(actor).findAll(ItemCard.ITEM_NAME).textContents()
        );
    }
}
