package com.iwasse.page.shopping;

import com.iwasse.page.AbstractPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends AbstractPageObject {

    @FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/h2")
    WebElement successMessageOrder;

    @FindBy(xpath = "//*[@data-test=\"back-to-products\"]")
    WebElement backHomeBtn;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String getSuccessMessage(){
        return this.successMessageOrder.getText();
    }

    public void backToHome(){
        this.backHomeBtn.click();
    }
}
