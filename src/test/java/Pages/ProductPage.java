package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BaseTest {

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "back-to-products")
    public WebElement backToProductsButton;

    @FindBy(id = "add-to-cart")
    public WebElement addToCartButton;

    @FindBy(id = "remove")
    public WebElement removeButton;

    @FindBy(xpath = "//span[contains(@data-test, \"shopping-cart-badge\")]")
    public WebElement shoppingCartBadge;

    @FindBy(xpath = "//a[contains(@data-test, \"shopping-cart-link\")]")
    public WebElement shoppingCartIcon;

    @FindBy(xpath = "//div[contains(@data-test, \"inventory-item-name\")]")
    public WebElement productOnProductPage;

    //----------------------------------------

    public void clickOnBackToProductsButton(){
        backToProductsButton.click();
    }

    public void clickOnAddToCartButton(){
        addToCartButton.click();
    }

    public void clickOnRemoveButton(){
        removeButton.click();
    }

    public String expectedNumberOnShoppingCartBadge(){
        return "1";
    }

    public void clickOnShoppingCartIcon(){
        shoppingCartIcon.click();
    }

    public String productPageURL(){
        return "https://www.saucedemo.com/inventory-item.html?id=4";
    }

    public boolean invisibilityOfShoppingCartBadgeInProductPage(){ //checking absence of shopping cart badge
        boolean shoppingCartBadgeIsDisplayed = false;
        try {
            shoppingCartBadgeIsDisplayed = shoppingCartBadge.isDisplayed();
        }catch (Exception exception){
            System.out.println(exception);
        }
        return shoppingCartBadgeIsDisplayed;
    }
}
