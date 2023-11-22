package com.iwasse.driver;

import com.iwasse.exception.BrowserNotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverFactory {

    public WebDriver createInstance(String browser) {
        WebDriver driver;

        BrowserList browserType = BrowserList.valueOf(browser.toUpperCase());

        switch (browserType) {
            case CHROME -> {
                //driver = WebDriverManager.chromedriver().create();
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
            }
            case FIREFOX -> driver = WebDriverManager.firefoxdriver().create();
            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                edgeOptions.addArguments("--no-sandbox");
                edgeOptions.addArguments("--disable-dev-shm-usage");
                edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
            }
            case SAFARI -> driver = WebDriverManager.safaridriver().create();
            default -> throw new BrowserNotSupportedException(browser);
        }

        return driver;
    }

    public enum BrowserList{
        CHROME, FIREFOX, EDGE, SAFARI
    }
}
