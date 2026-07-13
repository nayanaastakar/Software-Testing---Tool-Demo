package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferPage {

    WebDriver driver;
    WebDriverWait wait;

    public TransferPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    // =========================
    // Locators
    // =========================

    private final By transferFunds =
            By.linkText("Transfer Funds");

    private final By amount =
            By.id("amount");

    private final By fromAccount =
            By.id("fromAccountId");

    private final By toAccount =
            By.id("toAccountId");

    private final By transferButton =
            By.xpath("//input[@value='Transfer']");

    private final By successMessage =
            By.xpath("//h1[contains(text(),'Transfer Complete!')]");

    // =========================
    // Slow Typing
    // =========================

    private void slowType(By locator, String text)
            throws InterruptedException {

        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        element.clear();

        for(char c : text.toCharArray()){

            element.sendKeys(String.valueOf(c));

            Thread.sleep(150);

        }

    }

    // =========================

    public void clickTransferFunds() {

        wait.until(ExpectedConditions.elementToBeClickable(transferFunds));

        driver.findElement(transferFunds).click();

    }

    // =========================

    public void enterAmount(String value)
            throws InterruptedException {

        slowType(amount,value);

    }

    // =========================

    public void selectFromAccount() {

        Select select =
                new Select(driver.findElement(fromAccount));

        select.selectByIndex(0);

    }

    // =========================

    public void selectToAccount() {

        Select select =
                new Select(driver.findElement(toAccount));

        select.selectByIndex(1);

    }

    // =========================

    public void clickTransferButton() {

        driver.findElement(transferButton).click();

    }

    // =========================

    public boolean verifyTransfer() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));

        return driver.findElement(successMessage).isDisplayed();

    }

}