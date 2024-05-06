package com.expeditedtraining.uitesting.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemNameToIDMapper {

    private static Map<String, String> namesAndIds = Map.of(
            "sauce labs bike light", "0",
            "sauce labs bolt t-shirt", "1",
            "sauce labs onesie", "2",
            "test.allthethings() t-shirt", "3",
            "test.allthethings() t-shirt (red)", "3",
            "sauce labs backpack", "4",
            "sauce labs fleece jacket", "5"
    );

    public static List<String> map(List<String> itemNames) {
        List<String> ids = new ArrayList<>();

        for(String itemName : itemNames) {
            if(!(namesAndIds.containsKey(itemName.toLowerCase()))) {
                throw new IllegalArgumentException(itemName + " is not recognised as a valid item within this switch statement");
            }

            ids.add(namesAndIds.get(itemName.toLowerCase()));
        }

        return ids;
    }
}
