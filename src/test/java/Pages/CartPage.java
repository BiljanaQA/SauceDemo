package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class CartPage extends BaseTest {

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_item_name")
    public List<WebElement> itemName;

    @FindBy(xpath = "//button[contains(.,\"Remove\")]")
    public List<WebElement> removeButton;

    @FindBy(id = "continue-shopping")
    public WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    //-----------------------------------------

    public String cartProductsText(){ //return text of first product
        String nameOfFirstElement ="";
        if (itemName.size()>1){
            nameOfFirstElement = itemName.getFirst().getText();

        }else if (itemName.size()==1){
            nameOfFirstElement = itemName.getFirst().getText();
        }else{
            System.out.println("No products found!");
        }
        return nameOfFirstElement;
    }

    public void removeAllProducts(){
        for (WebElement e : removeButton){ // click on every remove button in a list
            e.click();
        }
    }

    public boolean invisibilityOfProducts(){
        return removeButton.isEmpty(); //returns true if list is empty
    }

    public void clickOnContinueShoppingButton(){
        continueShoppingButton.click();
    }

    //methods that are used for easier value reusability
    public String shoppingCartPageURL(){
        return "https://www.saucedemo.com/cart.html";
    }

    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }
}
