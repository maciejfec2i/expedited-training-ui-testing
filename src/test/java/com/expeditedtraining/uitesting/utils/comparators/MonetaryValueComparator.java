package com.expeditedtraining.uitesting.utils.comparators;

import java.util.Comparator;

public class MonetaryValueComparator implements Comparator<String> {

    @Override
    public int compare(String firstMonetaryValue, String secondMonetaryValue) {
        return Integer.compare(
                Integer.parseInt(firstMonetaryValue.replaceAll("[^0-9]+", "")),
                Integer.parseInt(secondMonetaryValue.replaceAll("[^0-9]+", ""))
        );
    }
}
