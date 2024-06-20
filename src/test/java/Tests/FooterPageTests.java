package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FooterPageTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        userLogin();
    }

    @Test(priority = 10) //TC11
    public void redirectionToTwitter(){
        footerPage.clickOnTwitterButton();
        goToNewWindow();
        waitForPageLoad(footerPage.twitterURL());
        Assert.assertEquals(driver.getCurrentUrl(), footerPage.twitterURL());
    }

    @Test(priority = 20) //TC12
    public void redirectionToFacebook(){
        footerPage.clickOnFacebookIcon();
        goToNewWindow();
        waitForPageLoad(footerPage.facebookURL());
        Assert.assertEquals(driver.getCurrentUrl(), footerPage.facebookURL());
    }

    @Test(priority = 30) //TC13
    public void redirectionToLinkedin(){
        footerPage.clickOnLinkedinIcon();
        goToNewWindow();
        waitForPageLoad(footerPage.linkedinURL());
        Assert.assertEquals(driver.getCurrentUrl(), footerPage.linkedinURL());
    }

    @AfterMethod
    public void closeTabAndGoToFirstWindow(){
        driver.close();
        goToFirstWindow();
    }
}
