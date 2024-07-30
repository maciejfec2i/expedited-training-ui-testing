package com.saucedemo.data;

public enum InventoryItem {

    SAUCE_LABS_BIKE_LIGHT("Sauce Labs Bike Light", 0),
    SAUCE_LABS_BOLT_TSHIRT("Sauce Labs Bolt T-Shirt", 1),
    SAUCE_LABS_ONESIE("Sauce Labs Onesie", 2),
    TESTALLTHETHINGS_TSHIRT("Test.allTheThings() T-Shirt", 3),
    SAUCE_LABS_BACKPACK("Sauce Labs Backpack", 4),
    SAUCE_LABS_FLEECE_JACKET("Sauce Labs Fleece Jacket", 5);

    private final String name;
    private final int id;

    InventoryItem(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }
}
