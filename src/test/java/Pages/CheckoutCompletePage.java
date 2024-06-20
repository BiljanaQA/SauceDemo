package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BaseTest {

    public CheckoutCompletePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "back-to-products")
    public WebElement backHomeButton;

    @FindBy(xpath = "//h2[contains(@data-test, \"complete-header\")]")
    public WebElement messageForSuccessfulOrder;

    //----------------------------------------------

    public void clickOnBackHomeButton(){
        backHomeButton.click();
    }

    public String textOfMessageForSuccessfulOrder(){
        return "Thank you for your order!";
    }
}
