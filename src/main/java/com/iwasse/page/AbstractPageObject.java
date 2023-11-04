package com.iwasse.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPageObject {

    protected AbstractPageObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
