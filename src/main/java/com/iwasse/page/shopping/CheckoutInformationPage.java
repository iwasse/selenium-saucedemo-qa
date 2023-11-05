package com.iwasse.page.shopping;

import com.iwasse.model.CheckoutData;
import com.iwasse.page.AbstractPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutInformationPage extends AbstractPageObject {

    @FindBy(xpath = "//*[@data-test=\"firstName\"]")
    WebElement firstName;

    @FindBy(xpath = "//*[@data-test=\"lastName\"]")
    WebElement lastName;

    @FindBy(xpath = "//*[@data-test=\"postalCode\"]")
    WebElement postalCode;

    @FindBy(xpath = "//*[@data-test=\"continue\"]")
    WebElement continueBtn;


    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    public void fillFirstName(String firstName){
        this.firstName.sendKeys(firstName);
    }

    public void fillLastName(String lastName){
        this.lastName.sendKeys(lastName);
    }

    public void fillPostalCode(String postalCode){
        this.postalCode.sendKeys(postalCode);
    }

    public void clickContinue(){
        this.continueBtn.click();
    }

    /**
     * @param info an object containing firstName, lastName and ZipCode
     */
    public void fillCheckoutInfo(CheckoutData info){
        fillFirstName(info.getFirstName());
        fillLastName(info.getLastName());
        fillPostalCode(info.getZipCode());
    }
}
