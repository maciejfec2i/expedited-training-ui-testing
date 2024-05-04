package com.expeditedtraining.uitesting.ui.compontents;

import net.serenitybdd.screenplay.targets.Target;

public class DraggableDiv {

    public static final Target WITH_TEXT = Target.the("Draggable div with text of '{0}'").locatedBy("//div[normalize-space() = '{0}']");
}
