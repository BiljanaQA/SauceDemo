package Tests;

import Base.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPageTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        userLogin();
    }

    @Test //TC24
    public void clickOnBackToProductsRedirectToInventoryPage(){
        inventoryPage.clickOnProductName();
        Assert.assertEquals(driver.getCurrentUrl(), productPage.productPageURL());

        productPage.clickOnBackToProductsButton();
        Assert.assertEquals(driver.getCurrentUrl(), inventoryPage.inventoryURL());
    }

    @Test //TC25
    public void addingProductToShoppingCart(){
        inventoryPage.clickOnProductName();
        Assert.assertEquals(driver.getCurrentUrl(), productPage.productPageURL());

        productPage.clickOnAddToCartButton();
        productPage.clickOnShoppingCartIcon();
        Assert.assertEquals(productPage.productOnProductPage.getText(), cartPage.cartProductsText());
    }

    @Test //TC26
    public void visibilityOfShoppingCartBadge(){
        inventoryPage.clickOnProductName();
        Assert.assertEquals(driver.getCurrentUrl(), productPage.productPageURL());

        productPage.clickOnAddToCartButton();
        Assert.assertEquals(productPage.shoppingCartBadge.getText(), productPage.expectedNumberOnShoppingCartBadge());

        productPage.clickOnRemoveButton();
        Assert.assertFalse(productPage.invisibilityOfShoppingCartBadgeInProductPage());
    }

    @AfterMethod
    public void emptyCart(){
        resetCart();
    }
}
