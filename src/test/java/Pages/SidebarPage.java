package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SidebarPage extends BaseTest {

    public SidebarPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    public WebElement hamburgerMenu;

    @FindBy(id = "inventory_sidebar_link")
    public WebElement allItems;

    @FindBy(id = "about_sidebar_link")
    public WebElement about;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logOut;

    @FindBy(id = "reset_sidebar_link")
    public WebElement resetAppState;

    //--------------------------------------------

    public void clickOnHamburgerMenu(){
        hamburgerMenu.click();
    }

    public void clickOnLogout(){
        logOut.click();
    }

    public void clickOnAbout(){
        about.click();
    }

    public void clickOnResetAppState(){
        resetAppState.click();
    }

    public void clickOnAllItems(){
        allItems.click();
    }

    //methods that are used for easier value reusability
    public String aboutPageURL(){
        return "https://saucelabs.com/";
    }
}
