package com.saucedemo.stepdefinitions;

import com.saucedemo.data.ErrorMessage;
import com.saucedemo.data.SortOrder;
import com.saucedemo.ui.pages.BasePageObject;
import com.saucedemo.ui.pages.factories.PageObjectFactory;
import io.cucumber.java.ParameterType;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

public class ParameterDefinitions {

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @ParameterType(".*")
    public PageObject page(String pageName) {
        return PageObjectFactory.from(BasePageObject.class.getPackage()).getPageCalled(pageName + "Page");
    }

    @ParameterType(".*")
    public ErrorMessage error(String errorMessageName) {
        return ErrorMessage.valueOf(errorMessageName.toUpperCase().replace(" ", "_"));
    }

    @ParameterType(".*")
    public SortOrder order(String sortOrderName) {
        return SortOrder.valueOf(sortOrderName.toUpperCase().replace(" ", "_"));
    }
}
