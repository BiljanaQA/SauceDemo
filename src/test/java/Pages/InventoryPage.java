package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class InventoryPage extends BaseTest {

    public InventoryPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_item_name")
    public List<WebElement> productList;

    @FindBy(xpath = "//button[contains(.,\"Add to cart\")]")
    public List<WebElement> addToCartButtonList;

    @FindBy(id = "shopping_cart_container")
    public WebElement shoppingCart;

    @FindBy(className = "inventory_item_name")
    public List<WebElement> itemName;

    @FindBy(className = "shopping_cart_badge")
    public WebElement shoppingCartBadge;

    @FindBy(xpath = "//button[contains(.,\"Remove\")]")
    public List<WebElement> removeButtonHomePage;

    //-----------------------------------------------

    public void clickOnAddToCartButtonOnFirstProduct(){
        if (addToCartButtonList.size()>1){
            addToCartButtonList.getFirst().click();
        }else if (addToCartButtonList.size()==1){
            addToCartButtonList.getFirst().click();
        }else {
            System.out.println("No products found!");
        }
    }

    public String addedProductsText(){ // return text of first product
        String firstProductText ="";
        if (productList.size()>1){
            firstProductText = productList.getFirst().getText();
        }else if (productList.size()==1){
            firstProductText = productList.getFirst().getText();
        }else{
            System.out.println("No products found!");
        }
        return firstProductText;
    }

    public void clickOnCart(){
        shoppingCart.click();
    }

    public String expectedShoppingCartBadgeNumber(){
        return "1";
    }

    public boolean invisibilityOfShoppingCartBadge(){ //checking absence of shopping cart badge
        boolean shoppingCartBadgeIsDisplayed = false;
        try {
            shoppingCartBadgeIsDisplayed = shoppingCartBadge.isDisplayed();
        }catch (Exception exception){
            System.out.println(exception);
        }
        return shoppingCartBadgeIsDisplayed;
    }

    public String inventoryURL(){
        return "https://www.saucedemo.com/inventory.html";
    }

    public void clickOnProductName(){
        if (productList.size()>1){
            productList.getFirst().click();
        }else if (productList.size()==1){
            productList.getFirst().click();
        }else{
            System.out.println("No products found!");
        }
    }

    public String productUrl(){
        return "https://www.saucedemo.com/inventory-item.html?id=4";
    }
}
