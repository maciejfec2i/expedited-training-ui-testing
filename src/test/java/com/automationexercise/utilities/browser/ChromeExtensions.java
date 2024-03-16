package com.automationexercise.utilities.browser;

import java.io.File;

public enum ChromeExtensions {

    AD_BLOCK("adBlock.crx");

    private final String defaultFilePath = "src" + File.separator +"test" + File.separator + "resources" + File.separator + "chromeExtensions";
    private final String filename;

    ChromeExtensions(String filename) {
        this.filename = filename;
    }

    public File getFile() {
        return new File(defaultFilePath + File.separator + filename);
    }
}
