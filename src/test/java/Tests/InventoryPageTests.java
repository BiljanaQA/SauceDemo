package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InventoryPageTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        userLogin();
    }

    @Test(priority = 20) //TC03
    public void addingAProductToShoppingCart(){
        inventoryPage.clickOnAddToCartButtonOnFirstProduct();
        inventoryPage.clickOnCart();
        Assert.assertEquals(inventoryPage.addedProductsText(), cartPage.cartProductsText());
    }

    @Test(priority = 10) //TC06
    public void manifestationOfShoppingCartBadge(){
        inventoryPage.clickOnAddToCartButtonOnFirstProduct();
        Assert.assertEquals(inventoryPage.shoppingCartBadge.getText(), inventoryPage.expectedShoppingCartBadgeNumber());

        inventoryPage.removeButtonHomePage.getFirst().click();
        Assert.assertFalse(inventoryPage.invisibilityOfShoppingCartBadge());
    }

    @Test(priority = 30) //TC08
    public void presenceOfProductPage(){
        inventoryPage.clickOnProductName();
        Assert.assertEquals(driver.getCurrentUrl(), inventoryPage.productUrl());
    }

    @AfterMethod
    public void emptyCart(){
        resetCart();
    }
}
