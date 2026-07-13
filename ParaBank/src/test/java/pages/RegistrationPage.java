package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class RegistrationPage {

    WebDriver driver;
    WebDriverWait wait;

    // Generated username for later login
    public static String generatedUsername;

    public RegistrationPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    // =========================
    // Locators
    // =========================

    By registerLink = By.linkText("Register");

    By firstName = By.id("customer.firstName");
    By lastName = By.id("customer.lastName");
    By address = By.id("customer.address.street");
    By city = By.id("customer.address.city");
    By state = By.id("customer.address.state");
    By zipCode = By.id("customer.address.zipCode");
    By phone = By.id("customer.phoneNumber");
    By ssn = By.id("customer.ssn");

    By username = By.id("customer.username");
    By password = By.id("customer.password");
    By confirmPassword = By.id("repeatedPassword");

    By registerButton = By.xpath("//input[@value='Register']");

    By logoutLink = By.linkText("Log Out");

    // =========================
    // Slow Typing
    // =========================

    private void slowType(By locator, String value) throws InterruptedException {

        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        element.clear();

        for(char c : value.toCharArray()){

            element.sendKeys(String.valueOf(c));

            Thread.sleep(120);

        }

    }

    // =========================
    // Click Register
    // =========================

    public void clickRegister() {

        wait.until(ExpectedConditions.elementToBeClickable(registerLink));

        driver.findElement(registerLink).click();

    }

    // =========================
    // Enter Details
    // =========================

    public void enterFirstName(String value) throws InterruptedException {

        slowType(firstName,value);

    }

    public void enterLastName(String value) throws InterruptedException {

        slowType(lastName,value);

    }

    public void enterAddress(String value) throws InterruptedException {

        slowType(address,value);

    }

    public void enterCity(String value) throws InterruptedException {

        slowType(city,value);

    }

    public void enterState(String value) throws InterruptedException {

        slowType(state,value);

    }

    public void enterZipCode(String value) throws InterruptedException {

        slowType(zipCode,value);

    }

    public void enterPhone(String value) throws InterruptedException {

        slowType(phone,value);

    }

    public void enterSSN(String value) throws InterruptedException {

        slowType(ssn,value);

    }

    // =========================
    // Generate Username
    // =========================

    public void enterUsername() throws InterruptedException {

        generatedUsername = "nayana" + (1000 + new Random().nextInt(9000));

        System.out.println("Generated Username : " + generatedUsername);

        slowType(username, generatedUsername);

    }

    public void enterPassword(String value) throws InterruptedException {

        slowType(password,value);

    }

    public void confirmPassword(String value) throws InterruptedException {

        slowType(confirmPassword,value);

    }

    // =========================
    // Register
    // =========================

    public void clickRegisterButton() {

        wait.until(ExpectedConditions.elementToBeClickable(registerButton));

        driver.findElement(registerButton).click();

    }

    // =========================
    // Verify Registration
    // =========================

    public boolean verifyRegistration() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));

        return driver.findElement(logoutLink).isDisplayed();

    }

}