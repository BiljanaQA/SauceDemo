package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutStepTwoPageTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        userLogin();
    }

    @Test //TC20
    public void cancelButtonRedirectToInventoryPage() {
        inventoryPage.clickOnAddToCartButtonOnFirstProduct();
        Assert.assertEquals(inventoryPage.shoppingCartBadge.getText(), inventoryPage.expectedShoppingCartBadgeNumber());

        inventoryPage.clickOnCart();
        cartPage.clickOnCheckoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage.checkoutPageURL());

        checkoutPage.formInput("Test", "Testic","1");
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage.stepTwoCheckoutPageURL());

        checkoutStepTwoPage.clickOnCancelButton();
        Assert.assertEquals(driver.getCurrentUrl(), inventoryPage.inventoryURL());
    }

    @Test //21
    public void finishButtonRedirectToCheckoutCompletePage(){
        inventoryPage.clickOnAddToCartButtonOnFirstProduct();
        Assert.assertEquals(inventoryPage.shoppingCartBadge.getText(), inventoryPage.expectedShoppingCartBadgeNumber());

        inventoryPage.clickOnCart();
        cartPage.clickOnCheckoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage.checkoutPageURL());

        checkoutPage.formInput("Test", "Testic","1");
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage.stepTwoCheckoutPageURL());

        checkoutStepTwoPage.clickOnFinishButton();
        Assert.assertEquals(driver.getCurrentUrl(), checkoutStepTwoPage.checkoutCompletePageURL());
    }

    @AfterMethod
    public void emptyCart(){
        resetCart();
    }
}
