package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenAccountPage {

    WebDriver driver;
    WebDriverWait wait;

    // Stores newly created account number
    public static String newAccountNumber;

    public OpenAccountPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    // ===========================
    // Locators
    // ===========================

    private final By openAccountLink =
            By.linkText("Open New Account");

    private final By accountType =
            By.id("type");

    private final By fromAccount =
            By.id("fromAccountId");

    private final By openAccountButton =
            By.xpath("//input[@value='Open New Account']");

    private final By successHeading =
            By.xpath("//h1[contains(text(),'Account Opened!')]");

    private final By accountNumber =
            By.id("newAccountId");

    // ===========================
    // Open Account Page
    // ===========================

    public void clickOpenAccount() {

        wait.until(ExpectedConditions.elementToBeClickable(openAccountLink));

        driver.findElement(openAccountLink).click();

    }

    // ===========================
    // Select Account Type
    // ===========================

    public void selectAccountType(String type) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(accountType));

        Select select =
                new Select(driver.findElement(accountType));

        select.selectByVisibleText(type);

    }

    // ===========================
    // Open Account
    // ===========================

    public void clickOpenAccountButton() {

        wait.until(ExpectedConditions.elementToBeClickable(openAccountButton));

        driver.findElement(openAccountButton).click();

    }

    // ===========================
    // Verify Account
    // ===========================

    public boolean verifyAccountCreated() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(successHeading));

        wait.until(ExpectedConditions.visibilityOfElementLocated(accountNumber));

        newAccountNumber =
                driver.findElement(accountNumber).getText();

        System.out.println();
        System.out.println("========================================");
        System.out.println("🏦 NEW ACCOUNT CREATED");
        System.out.println("Account Number : " + newAccountNumber);
        System.out.println("========================================");

        return driver.findElement(successHeading).isDisplayed();

    }

}