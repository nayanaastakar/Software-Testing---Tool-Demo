package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    // ===========================
    // Locators
    // ===========================

    private final By username = By.name("username");

    private final By password = By.name("password");

    private final By loginButton = By.xpath("//input[@value='Log In']");

    private final By errorMessage = By.xpath("//p[@class='error']");

    private final By logoutLink = By.linkText("Log Out");

    // ===========================
    // Slow Typing Method
    // ===========================

    private void slowType(By locator, String text) throws InterruptedException {

        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        element.clear();

        for (char ch : text.toCharArray()) {

            element.sendKeys(String.valueOf(ch));

            Thread.sleep(150);     // typing speed

        }

    }

    // ===========================
    // Actions
    // ===========================

    public void enterUsername(String user) throws InterruptedException {

        System.out.println("Typing Username...");

        slowType(username, user);

    }

    public void enterPassword(String pass) throws InterruptedException {

        System.out.println("Typing Password...");

        slowType(password, pass);

    }

    public void clickLogin() {

        wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        driver.findElement(loginButton).click();

        wait.until(ExpectedConditions.or(

                ExpectedConditions.urlContains("overview"),

                ExpectedConditions.visibilityOfElementLocated(errorMessage)

        ));

    }

    // ===========================
    // Verification
    // ===========================

    public boolean verifyLogin() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));

        return driver.findElement(logoutLink).isDisplayed();

    }

    public boolean verifyErrorMessage() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));

        return driver.findElement(errorMessage).isDisplayed();

    }

}