package com.expeditedtraining.uitesting.user.actions.ui;

public class SortTable {

    private String by;

    public SortTable(String by) {
        this.by = by;
    }

    public static SortTable by(String by) {
        return new SortTable(by);
    }

    public SortTableInOrder inOrder(String sortOrder) {
        return new SortTableInOrder(this.by, sortOrder);
    }
}
