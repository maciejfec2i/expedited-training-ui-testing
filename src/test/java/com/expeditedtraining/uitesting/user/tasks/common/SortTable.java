package com.expeditedtraining.uitesting.user.tasks.common;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class SortTable {

    private final String columnName;

    public SortTable(String columnName) {
        this.columnName = columnName;
    }

    public static SortTable by(String columnName) {
        return new SortTable(columnName);
    }

    public Performable inOrderOf(String sortOrder) {
        return Task.where(
                "{0} sort(s) the table by " + columnName + " in " + sortOrder + " order",
                Tasks.instrumented(SortTableByColumnInOrderOf.class, columnName, sortOrder)
        );
    }
}
