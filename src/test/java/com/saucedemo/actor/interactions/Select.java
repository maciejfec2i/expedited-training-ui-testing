package com.saucedemo.actor.interactions;

import com.saucedemo.actor.interactions.select.SelectOptionFromTargetByVisibleText;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.targets.Target;

/**
 * The purpose of this class is to act as something of a factory for {@link Performable} tasks related to selecting
 * an option located by the strategy of choice.<br><br>
 *
 * New methods can be added as required.
 */
public class Select {

    private final String option;

    public Select(String option) {
        this.option = option;
    }

    public static Select theOptionWithTextOf(String optionText) {
        return new Select(optionText);
    }

    public Performable from(Target targetSelect) {
        return Tasks.instrumented(SelectOptionFromTargetByVisibleText.class, option, targetSelect);
    }
}
