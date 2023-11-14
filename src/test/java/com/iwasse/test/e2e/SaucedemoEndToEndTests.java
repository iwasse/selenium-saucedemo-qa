package com.iwasse.test.e2e;

import com.iwasse.BaseWeb;
import com.iwasse.data.CheckoutInfoDataFactory;
import com.iwasse.page.shopping.*;
import com.iwasse.page.login.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class SaucedemoEndToEndTests extends BaseWeb {

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
        //get the total number of products of page
        var totalProducts = shopping.getItemList().size();
        //get a random product
        var randomProduct = random.nextInt(totalProducts - 1) + 1;

        shopping.getAddCartButtonsList().get(randomProduct).click();

        //Assert if number of items in cart is correct
        Assert.assertEquals(1, shopping.getCartNumberOfItems());

        //Access shopping cart & checkout
        shopping.accessShoppingCart();

        var cartPage = new CartPage(driver);
        cartPage.doCheckout();

        var checkoutInformationPage = new CheckoutInformationPage(driver);
        var checkoutData = CheckoutInfoDataFactory.createValidCheckoutInfo();
        checkoutInformationPage.fillCheckoutInfo(checkoutData);
        checkoutInformationPage.clickContinue();

        var checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.finishOrder();

        var checkoutCompletePage = new CheckoutCompletePage(driver);
        Assert.assertEquals(checkoutCompletePage.getSuccessMessage(), "Thank you for your order!");
    }
}
