package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BaseTest {
    /*
                                        ***POM***
    - POM is used to maintain clean and easily maintainable test code.
      It allows for better test organization and code reusability.
      POM treats each page of a web application as a separate object in the test code.
      This object represents the page and provides methods for interacting with the elements on that page.

                                     ***Annotations***
    - @BeforeClass is executed only once before any tests in the class are executed.
      It is used for setting up resources that will be shared across all tests, such as initializing the WebDriver.
      WebDriver enables interaction with web pages in the same way a real user would.

    - @AfterClass is executed only once after all tests in the class have finished.
      It is used for cleaning up resources, such as closing the WebDriver.

    - @BeforeMethod is executed once before each @Test.
      It maximizes the browser window and prepares the necessary setup before the execution of each individual test.

    - @AfterMethod is executed after every test method in the same class.
      It is typically used to perform cleanup tasks after each individual test.

    - @Test is used for executing test methods within a test class.
      it contains assertions that are typically used to validate expected behavior and outcomes.

     */


    public static WebDriver driver;
    public WebDriverWait wait;
    public LoginPage loginPage;
    public InventoryPage inventoryPage;
    public CartPage cartPage;
    public FooterPage footerPage;
    public SidebarPage sidebarPage;
    public CheckoutPage checkoutPage;
    public CheckoutStepTwoPage checkoutStepTwoPage;
    public CheckoutCompletePage checkoutCompletePage;
    public ProductPage productPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        String driverPath = ConfigReader.get("chrome.driver.path");
        String binaryPath = ConfigReader.get("chrome.binary.path");

        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.setBinary(binaryPath);

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        footerPage = new FooterPage();
        sidebarPage = new SidebarPage();
        checkoutPage = new CheckoutPage();
        checkoutStepTwoPage = new CheckoutStepTwoPage();
        checkoutCompletePage = new CheckoutCompletePage();
        productPage = new ProductPage();
    }
    //---------------------------------------------------------
    //help me! - methods

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void userLogin() {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
    }

    public void waitForPageLoad(String url) {
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public void goToNewWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowStrings = new ArrayList<>(windowHandles);
        String reqWindow = windowStrings.get(1);
        driver.switchTo().window(reqWindow);
    }

    public void goToFirstWindow(){
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowStrings = new ArrayList<>(windowHandles);
        String reqWindow = windowStrings.getFirst();
        driver.switchTo().window(reqWindow);
    }

    public void resetCart() {
        sidebarPage.clickOnHamburgerMenu();
        waitForVisibilityOfElement(sidebarPage.resetAppState);
        sidebarPage.clickOnResetAppState();
    }

    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
