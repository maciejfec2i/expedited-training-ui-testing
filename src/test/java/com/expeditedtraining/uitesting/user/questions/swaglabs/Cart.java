package com.expeditedtraining.uitesting.user.questions.swaglabs;

import net.serenitybdd.screenplay.Question;

import java.util.List;

public class Cart {

    public static Question<List<String>> items() {
        return Question
                .about("Names of all the items in the cart")
                .answeredBy(new NamesOfAllCartItems());
    }
}
