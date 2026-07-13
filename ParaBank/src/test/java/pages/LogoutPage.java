package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public LogoutPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    By logout = By.linkText("Log Out");

    By loginButton = By.xpath("//input[@value='Log In']");

    public void clickLogout() {

        wait.until(ExpectedConditions.elementToBeClickable(logout));

        driver.findElement(logout).click();

        driver.manage().deleteAllCookies();

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));

    }
    public boolean verifyLogout() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));

        return driver.findElement(loginButton).isDisplayed();

    }

}