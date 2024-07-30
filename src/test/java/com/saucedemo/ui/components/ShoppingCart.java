package com.saucedemo.ui.components;

import net.serenitybdd.screenplay.targets.Target;

public class ShoppingCart {

    public final static Target LINK = Target.the("shopping cart link").locatedBy("css:a[data-test = 'shopping-cart-link']");
}
