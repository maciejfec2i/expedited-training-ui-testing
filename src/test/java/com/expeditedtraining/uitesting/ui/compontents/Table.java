package com.expeditedtraining.uitesting.ui.compontents;

import net.serenitybdd.screenplay.targets.Target;

public class Table {

    public static final Target COLUMN_HEADER = Target
            .the("Column Header for {0}")
            .locatedBy("//table[@id = 'table1']//th[normalize-space() = '{0}']");
    public static final Target ALL_COLUMN_HEADERS = Target
            .the("All column headers")
            .locatedBy("//table[@id = 'table1']//th");
    public static final Target VALUES_UNDER_COLUMN_WITH_INDEX = Target
            .the("All values under column with index of {0}")
            .locatedBy("//table[@id = 'table1']//tbody//tr//td[{0}]");
}
