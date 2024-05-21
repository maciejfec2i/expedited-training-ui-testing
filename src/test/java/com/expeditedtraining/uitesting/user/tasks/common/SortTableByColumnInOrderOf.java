package com.expeditedtraining.uitesting.user.tasks.common;

import com.expeditedtraining.uitesting.ui.compontents.Table;
import com.expeditedtraining.uitesting.user.interactions.Click;
import com.expeditedtraining.uitesting.user.interactions.DoubleClick;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SortTableByColumnInOrderOf implements Performable, IsHidden {

    private final Logger LOGGER = LoggerFactory.getLogger(SortTableByColumnInOrderOf.class);

    private final String columnHeader;
    private final String sortOrder;

    public SortTableByColumnInOrderOf(String columnHeader, String sortOrder) {
        this.columnHeader = columnHeader;
        this.sortOrder = sortOrder;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} attempts sort the table by {} in {} order", actor.getName(), columnHeader, sortOrder);

        Target targetColumn = Table.COLUMN_HEADER.of(columnHeader);
        Performable sortTable = sortOrder.equalsIgnoreCase("ascending") ? Click.on(targetColumn) : DoubleClick.on(targetColumn);

        actor.attemptsTo(sortTable);
    }
}
