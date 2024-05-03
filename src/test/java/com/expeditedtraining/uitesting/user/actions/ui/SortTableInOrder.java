package com.expeditedtraining.uitesting.user.actions.ui;

import com.expeditedtraining.uitesting.ui.compontents.Table;
import com.expeditedtraining.uitesting.user.actions.ui.base.ClickOn;
import com.expeditedtraining.uitesting.user.actions.ui.base.DoubleClickOn;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;

public class SortTableInOrder implements Performable, IsHidden {

    private String by;
    private String order;

    public SortTableInOrder(String by, String order) {
        this.by = by;
        this.order = order;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Performable sortTable = this.order.equalsIgnoreCase("ascending") ?
                                ClickOn.the(Table.COLUMN_HEADER.of(this.by)) :
                                DoubleClickOn.the(Table.COLUMN_HEADER.of(this.by));

        actor.attemptsTo(sortTable);
    }
}
