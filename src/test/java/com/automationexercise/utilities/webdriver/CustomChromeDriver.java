package com.automationexercise.utilities.webdriver;

import com.automationexercise.utilities.browser.ChromeExtensions;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CustomChromeDriver implements DriverSource {

    @Override
    public WebDriver newDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.addArguments(
                "remote-allow-origins=*",
                "test-type",
                "no-sandbox",
                "ignore-certificate-errors",
                "start-maximized",
                "incognito",
                "disable-infobars",
                "disable-gpu",
                "disable-default-apps",
                "disable-popup-blocking",
                "disable-extensions-file-access-check"
        );
        chromeOptions.addExtensions(ChromeExtensions.AD_BLOCK.getFile());

        return new ChromeDriver(chromeOptions);
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
