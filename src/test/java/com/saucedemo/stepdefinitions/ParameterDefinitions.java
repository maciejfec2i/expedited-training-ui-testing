package com.saucedemo.stepdefinitions;

import com.google.common.base.Strings;
import com.saucedemo.data.ErrorMessage;
import com.saucedemo.data.SortOrder;
import com.saucedemo.ui.components.InventoryItem;
import com.saucedemo.ui.pages.BasePageObject;
import com.saucedemo.ui.pages.factories.PageObjectFactory;
import io.cucumber.java.ParameterType;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.targets.Target;

import java.util.ArrayList;
import java.util.List;

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

    @ParameterType(".*")
    public List<String> items(String itemNames) {
        return Strings.isNullOrEmpty(itemNames) ? new ArrayList<>() : List.of(itemNames.split(", "));
    }

    @ParameterType(".*")
    public Target button(String buttonText) {
        String lowerCaseButtonText = buttonText.toLowerCase();

        if(lowerCaseButtonText.contains("add")) return InventoryItem.ADD_TO_CART_BUTTON;
        else if(lowerCaseButtonText.contains("remove")) return InventoryItem.REMOVE_FROM_CART_BUTTON;
        else throw new RuntimeException();
    }
}
