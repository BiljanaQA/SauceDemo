package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SidebarTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        userLogin();
    }

    @Test //TC14
    public void userLoggingOut(){
        sidebarPage.clickOnHamburgerMenu();
        waitForVisibilityOfElement(sidebarPage.logOut);
        sidebarPage.clickOnLogout();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }

    @Test //TC15
    public void resetAppStateAfterAddingProductsToCart(){
        inventoryPage.clickOnAddToCartButtonOnFirstProduct();
        Assert.assertEquals(inventoryPage.shoppingCartBadge.getText(), inventoryPage.expectedShoppingCartBadgeNumber());

        sidebarPage.clickOnHamburgerMenu();
        waitForVisibilityOfElement(sidebarPage.resetAppState);
        sidebarPage.clickOnResetAppState();
        Assert.assertFalse(inventoryPage.invisibilityOfShoppingCartBadge());

        inventoryPage.clickOnCart();
        Assert.assertTrue(cartPage.invisibilityOfProducts());
    }

    @Test //TC16
    public void redirectsToInventoryByClickingOnAllItems(){
        inventoryPage.clickOnCart();
        Assert.assertEquals(driver.getCurrentUrl(),cartPage.shoppingCartPageURL());

        sidebarPage.clickOnHamburgerMenu();
        waitForVisibilityOfElement(sidebarPage.allItems);
        sidebarPage.clickOnAllItems();
        Assert.assertEquals(driver.getCurrentUrl(), inventoryPage.inventoryURL());
    }

    @Test //TC23
    public void redirectsToAboutPageByClickingOnAbout(){
        sidebarPage.clickOnHamburgerMenu();
        waitForVisibilityOfElement(sidebarPage.about);
        sidebarPage.clickOnAbout();
        Assert.assertEquals(driver.getCurrentUrl(), sidebarPage.aboutPageURL());
    }
}
