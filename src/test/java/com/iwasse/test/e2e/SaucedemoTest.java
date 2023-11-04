package com.iwasse.test.e2e;

import com.iwasse.BaseWeb;
import com.iwasse.page.shopping.*;
import com.iwasse.page.login.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class SaucedemoTest extends BaseWeb {

    Random random = new Random();

    @Test(description = "e2e")
    public void endToEnd(){
        var loginPage = new LoginPage(driver);

        //login
        loginPage.fillUsername("standard_user");
        loginPage.fillPassword("secret_sauce");
        loginPage.clickLogin();

        //get a random product and add to cart
        var shopping = new Shopping(driver);
        var totalItems = shopping.getItemList().size();
        var randomItem = random.nextInt(totalItems - 1) + 1;

        shopping.getAddCartButtonsList().get(randomItem).click();

        //Access shopping cart & checkout
        shopping.accessShoppingCart();

        var cartPage = new CartPage(driver);
        cartPage.doCheckout();

        var checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutInformationPage.fillFirstName("Guilherme");
        checkoutInformationPage.fillLastName("de Brito Iwasse");
        checkoutInformationPage.fillPostalCode("74015020");
        checkoutInformationPage.clickContinue();

        var checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.finishOrder();

        var checkoutCompletePage = new CheckoutCompletePage(driver);
        Assert.assertEquals(checkoutCompletePage.getSuccessMessage(), "Thank you for your order!");

//        products.accessMenu();
//
//        products.logout();
    }
}
