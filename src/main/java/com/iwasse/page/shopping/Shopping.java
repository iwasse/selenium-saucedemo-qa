package com.iwasse.page.shopping;

import com.iwasse.page.AbstractPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Shopping extends AbstractPageObject {
    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    WebElement menu;

    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    WebElement logoutBtn;

    @FindBy(xpath = "//*[@class=\"inventory_item_name \"]")
    List<WebElement> itemList;

    @FindBy(xpath = "//*[@class=\"btn btn_primary btn_small btn_inventory \"]")
    List<WebElement> addCartButtonsList;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    WebElement shoppingCart;

    @FindBy(xpath = "//*[@class=\"shopping_cart_badge\"]")
    WebElement cartItemNumbers;

    public Shopping(WebDriver driver) {
        super(driver);
    }

    public void accessMenu(){
        this.menu.click();
    }

    public void logout(){
        this.logoutBtn.click();
    }

    public List<WebElement> getItemList(){
        return this.itemList;
    }

    public List<WebElement> getAddCartButtonsList(){
        return this.addCartButtonsList;
    }

    public void accessShoppingCart(){
        this.shoppingCart.click();
    }

    public Integer getCartNumberOfItems(){
        return Integer.parseInt(cartItemNumbers.getText());
    }

}
