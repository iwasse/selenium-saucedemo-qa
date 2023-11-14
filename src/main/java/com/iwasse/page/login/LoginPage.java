package com.iwasse.page.login;

import com.iwasse.page.AbstractPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPageObject {

    @FindBy(xpath = "//*[@data-test=\"username\"]")
    WebElement username;

    @FindBy(xpath = "//*[@data-test=\"password\"]")
    WebElement password;

    @FindBy(xpath = "//*[@data-test=\"login-button\"]")
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillUsername(String username){
        this.username.sendKeys(username);
    }

    public void fillPassword(String password){
        this.password.sendKeys(password);
    }

    public void clickLogin(){
        this.loginBtn.click();
    }


}
