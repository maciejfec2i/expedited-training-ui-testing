package com.saucedemo.data.comparators;

import com.saucedemo.data.SortOrder;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import static com.saucedemo.data.SortOrder.*;

public class InventoryItemComparator implements Comparator<String> {

    private final Collection<String> values;

    public InventoryItemComparator(Collection<String> values) {
        this.values = values;
    }

    public static InventoryItemComparator sortValuesOf(Collection<String> values) {
        return new InventoryItemComparator(values);
    }

    public Collection<String> inOrderOf(SortOrder order) {
        Comparator<String> comparator = order.equals(DESCENDING) ? this.reversed() : this;
        return values.stream().sorted(comparator).collect(Collectors.toList());
    }

    @Override
    public int compare(String firstItemValue, String secondItemValue) {
        if(firstItemValue.contains("$") && secondItemValue.contains("$")) {
            double firstItemPrice = Double.parseDouble(firstItemValue.replaceAll("[^\\d.]", ""));
            double secondItemPrice = Double.parseDouble(secondItemValue.replaceAll("[^\\d.]", ""));

            return Double.compare(firstItemPrice, secondItemPrice);
        }

        return String.CASE_INSENSITIVE_ORDER.compare(firstItemValue, secondItemValue);
    }
}
