package com.iwasse.page.shopping;

import com.iwasse.page.AbstractPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends AbstractPageObject {


    @FindBy(xpath = "//*[@data-test=\"finish\"]")
    WebElement finishBtn;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public void finishOrder(){
        this.finishBtn.click();
    }
}
