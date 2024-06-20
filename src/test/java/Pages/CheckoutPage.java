package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutPage extends BaseTest {

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public WebElement lastName;

    @FindBy(id = "postal-code")
    public  WebElement postlCode;

    @FindBy(id = "continue")
    public WebElement continueButton;

    //---------------------------------------------

    // methods that are used for easier value reusability
    public String checkoutPageURL(){
        return "https://www.saucedemo.com/checkout-step-one.html";
    }

    public String stepTwoCheckoutPageURL(){
        return "https://www.saucedemo.com/checkout-step-two.html";
    }

    public void formInput(String fName, String lName, String zipNumber){
       firstName.sendKeys(fName);
       lastName.sendKeys(lName);
       postlCode.sendKeys(zipNumber);
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }
}
