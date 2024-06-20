package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutPageTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        userLogin();
    }

    @Test //TC18
    public void checkoutButtonOpenCheckoutPage(){
        inventoryPage.clickOnAddToCartButtonOnFirstProduct();
        Assert.assertEquals(inventoryPage.shoppingCartBadge.getText(), inventoryPage.expectedShoppingCartBadgeNumber());

        inventoryPage.clickOnCart();
        cartPage.clickOnCheckoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage.checkoutPageURL());
    }

    @Test //TC19
    public void continueButtonOpenSecondStep(){
        //method is used as all steps should be reproduced
        checkoutButtonOpenCheckoutPage();
        checkoutPage.formInput("Test", "Testic","1");
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage.stepTwoCheckoutPageURL());
    }

    @AfterMethod

    // this method ensures that the other test starts with an empty cart
    public void emptyCart(){
        resetCart();
    }
}
