package com.iwasse.test.functional;

import com.iwasse.BaseWeb;
import com.iwasse.page.login.LoginPage;
import com.iwasse.page.shopping.Shopping;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class SaucedemoFunctionalTests extends BaseWeb {

    Random random = new Random();

    @BeforeMethod
    void login(){
        var loginPage = new LoginPage(driver);
        loginPage.fillUsername("standard_user");
        loginPage.fillPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @Test
    public void givenShopping_whenAddItemCart_thenCartBadgeShouldAppear(){
        var shopping = new Shopping(driver);
        //get the total number of products of page
        var totalProducts = shopping.getItemList().size();
        //get a random product
        var randomProduct = random.nextInt(totalProducts - 1) + 1;

        shopping.getAddCartButtonsList().get(randomProduct).click();

        //Assert if number of items in cart is correct
        Assert.assertEquals(1, shopping.getCartNumberOfItems());
    }
    @Test
    public void givenItemInCart_whenRemoved_thenCartShouldBeEmpty(){

        //get a random product and add to cart
        var shopping = new Shopping(driver);
        //get the total number of products of page
        var totalProducts = shopping.getItemList().size();
        //get a random product
        var randomProduct = random.nextInt(totalProducts - 1) + 1;

        shopping.getAddCartButtonsList().get(randomProduct).click();

        //Assert if number of items in cart is correct
        Assert.assertEquals(1, shopping.getCartNumberOfItems());

        shopping.getRemoveCartButtonsList().forEach(WebElement::click);

        Assert.assertTrue(driver.findElements(By.className("shopping_cart_badge")).isEmpty());

    }


}
