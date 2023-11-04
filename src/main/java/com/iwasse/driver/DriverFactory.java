package com.iwasse.driver;

import com.iwasse.exception.BrowserNotSupportedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public WebDriver createInstance(String browser) {
        WebDriver driver;

        BrowserList browserType = BrowserList.valueOf(browser.toUpperCase());

        switch(browserType) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            default:
                throw new BrowserNotSupportedException(browser);
        }

        return driver;
    }

    public enum BrowserList{
        CHROME, FIREFOX, EDGE, SAFARI
    }
}
