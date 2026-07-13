package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    // Locators
    By backpack = By.id("add-to-cart-sauce-labs-backpack");
    By removeButton = By.id("remove-sauce-labs-backpack");
    By cart = By.className("shopping_cart_link");
    By cartBadge = By.className("shopping_cart_badge");
    By product = By.xpath("//div[text()='Sauce Labs Backpack']");
    By checkout = By.id("checkout");

    By firstName = By.id("first-name");

    By lastName = By.id("last-name");

    By postalCode = By.id("postal-code");

    By continueBtn = By.id("continue");

    By finishBtn = By.id("finish");

    By completeHeader = By.className("complete-header");
    // Add Backpack
    public void addBackpack() throws InterruptedException {

        // Wait after login
        Thread.sleep(3000);

        wait.until(ExpectedConditions.elementToBeClickable(backpack));

        driver.findElement(backpack).click();

        System.out.println("✅ Clicked Add to Cart");

        // Wait so audience can see the button change
        Thread.sleep(3000);
    }

    // Verify button changed
    public boolean verifyAdded() {

        return !driver.findElements(removeButton).isEmpty();

    }

    // Verify badge shows 1
    public boolean verifyCartBadge() {

        if (driver.findElements(cartBadge).isEmpty()) {
            return false;
        }

        return driver.findElement(cartBadge).getText().equals("1");

    }
    // Open cart
    public void openCart() throws InterruptedException {

        // Wait after product is added
        Thread.sleep(3000);

        wait.until(ExpectedConditions.elementToBeClickable(cart));

        driver.findElement(cart).click();

        // Wait after cart opens
        Thread.sleep(3000);
    }

    // Verify product in cart
    public boolean verifyProduct() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(product));

        // Keep the cart page visible
        Thread.sleep(5000);

        return driver.findElement(product).isDisplayed();
    }
    public void clickCheckout() {

        wait.until(ExpectedConditions.elementToBeClickable(checkout));

        driver.findElement(checkout).click();

    }

    public void enterFirstName(String fname) {

        driver.findElement(firstName).sendKeys(fname);

    }

    public void enterLastName(String lname) {

        driver.findElement(lastName).sendKeys(lname);

    }

    public void enterPostalCode(String code) {

        driver.findElement(postalCode).sendKeys(code);

    }

    public void clickContinue() throws InterruptedException {

        driver.findElement(continueBtn).click();

        // Pause on the Checkout Overview page
        Thread.sleep(5000);

    }

    public void clickFinish() throws InterruptedException {

        // Wait before placing the order
        Thread.sleep(5000);

        wait.until(ExpectedConditions.elementToBeClickable(finishBtn));

        driver.findElement(finishBtn).click();

    }

    public boolean verifyOrder() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(completeHeader));

        return driver.findElement(completeHeader)
                .getText()
                .equals("Thank you for your order!");

    }

}
