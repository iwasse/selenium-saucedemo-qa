package com.iwasse.page.shopping;

import com.iwasse.page.AbstractPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPageObject {

    @FindBy(xpath = "//*[@id=\"checkout\"]")
    WebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void doCheckout(){
        this.checkoutBtn.click();
    }

}
