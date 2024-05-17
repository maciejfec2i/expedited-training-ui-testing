package com.expeditedtraining.uitesting.ui.pages.theinternet;

import com.expeditedtraining.uitesting.ui.pages.BasePageObject;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("the.internet.js.alerts.url")
public class JavaScriptAlertsPage extends BasePageObject {

    public static final Target ALERT_ACTION_RESULT = Target.the("JS Alert Action Result").locatedBy("#result");
}
