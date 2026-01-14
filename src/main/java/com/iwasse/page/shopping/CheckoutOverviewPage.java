package com.iwasse.page.shopping;

import com.iwasse.page.AbstractPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutOverviewPage extends AbstractPageObject {


    @FindBy(xpath = "//*[@data-test=\"finish\"]")
    WebElement finishBtn;

    private final WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void finishOrder(){
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        wait.until(driver -> finishBtn.isDisplayed());
        this.finishBtn.click();
    }
}
