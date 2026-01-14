package com.iwasse;

import com.iwasse.config.Configuration;
import com.iwasse.driver.DriverFactory;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners({TestListener.class})
public class BaseWeb {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){

        Configuration config = ConfigFactory.create(Configuration.class);

        driver = new DriverFactory().createInstance(config.browser());

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(config.url());

    }

    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }
}
