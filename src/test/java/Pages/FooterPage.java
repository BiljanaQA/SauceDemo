package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage extends BaseTest {

    public FooterPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(.,\"Twitter\")]")
    public WebElement twitterIcon;

    @FindBy(xpath = "//a[contains(.,\"Facebook\")]")
    public WebElement facebookIcon;

    @FindBy(xpath = "//a[contains(.,\"LinkedIn\")]")
    public WebElement linkedinIcon;

    //----------------------------------

    public void clickOnTwitterButton(){
        scrollToElement(twitterIcon);
        twitterIcon.click();
    }

    public String twitterURL(){
        return "https://x.com/saucelabs";
    }

    public void clickOnFacebookIcon(){
        scrollToElement(facebookIcon);
        facebookIcon.click();
    }

    public String facebookURL(){
        return "https://www.facebook.com/saucelabs";
    }

    public void clickOnLinkedinIcon(){
        scrollToElement(linkedinIcon);
        linkedinIcon.click();
    }

    public String linkedinURL(){
        return "https://www.linkedin.com/company/sauce-labs/";
    }
}
