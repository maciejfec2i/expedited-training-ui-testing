package com.expeditedtraining.uitesting.ui.pages;

import com.expeditedtraining.uitesting.utils.Environment;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;

public abstract class BasePageObject extends PageObject {

    @Override
    public String toString() {
        String annotationValue = this.getClass().getAnnotation(DefaultUrl.class).value();
        return Environment.getEnvironmentSpecificConfiguration().getProperty(annotationValue);
    }
}
