package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test //TC01
    public void userCanNotLogInWithInvalidData(){
        loginPage.inputUsername("test123");
        loginPage.inputPassword("test");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertEquals(loginPage.errorMessage.getText(), loginPage.expectedErrorMessageText());
    }

    @Test //TC02
    public void userCanLoginWithValidData(){
        userLogin();
        Assert.assertEquals(driver.getCurrentUrl(), inventoryPage.inventoryURL());
    }
}
