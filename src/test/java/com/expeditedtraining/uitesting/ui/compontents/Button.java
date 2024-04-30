package com.expeditedtraining.uitesting.ui.compontents;

import net.serenitybdd.screenplay.targets.Target;

public class Button {

    public static final Target WITH_TEXT = Target.the("Button with text of '{0}'").locatedBy("//button[normalize-space() = '{0}']");
}
