package com.kodilla.testing2.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverConfig {

    public final static String CHROME = "CHROME_DRIVER";

    public static WebDriver getDriver(final String driver) {

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        if (driver.equals(CHROME)) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-search-engine-choice-screen");
            return new ChromeDriver(chromeOptions);
        } else {
            return null;
        }
    }
}
