package com.iwasse;

import com.iwasse.config.Configuration;
import com.iwasse.driver.DriverFactory;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

@Listeners({TestListener.class})
public class BaseWeb {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){

        Configuration config = ConfigFactory.create(Configuration.class);

        driver = new DriverFactory().createInstance(config.browser());

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(config.url());

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
