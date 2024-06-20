package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        userLogin();
    }

    @Test //TC04
    public void removeProductFromShoppingCart(){
        inventoryPage.clickOnAddToCartButtonOnFirstProduct();
        inventoryPage.clickOnCart();
        //compare if selected product on inventory page is the same as products on the cart page
        Assert.assertEquals(inventoryPage.addedProductsText(), cartPage.cartProductsText());

        cartPage.removeAllProducts();
        Assert.assertTrue(cartPage.invisibilityOfProducts());
    }

    @Test //TC05
    public void checkIfShoppingCartIsEmpty(){
        inventoryPage.clickOnCart();
        Assert.assertTrue(cartPage.invisibilityOfProducts());
    }

    @Test //TC07
    public void verifyReturningToInventoryPageFromCartPage(){
        inventoryPage.clickOnCart();
        cartPage.clickOnContinueShoppingButton();
        Assert.assertEquals(driver.getCurrentUrl(),inventoryPage.inventoryURL());
    }
}
