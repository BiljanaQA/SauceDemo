package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckCompletePageTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        userLogin();
    }

    @Test //TC22
    public void backHomeButtonRedirectToInventoryPage(){
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
        Assert.assertTrue(checkoutCompletePage.messageForSuccessfulOrder.isDisplayed());
        Assert.assertEquals(checkoutCompletePage.messageForSuccessfulOrder.getText(),
                checkoutCompletePage.textOfMessageForSuccessfulOrder());

        checkoutCompletePage.clickOnBackHomeButton();
        Assert.assertEquals(driver.getCurrentUrl(), inventoryPage.inventoryURL());
    }
}
