package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");

    // Method to type text slowly
    private void slowType(By locator, String text) throws InterruptedException {

        for (char ch : text.toCharArray()) {
            driver.findElement(locator).sendKeys(String.valueOf(ch));
            Thread.sleep(200);    // Delay between each character
        }
    }

    // Enter Username
    public void enterUsername(String user) throws InterruptedException {

        Thread.sleep(1000);   // Wait before typing

        slowType(username, user);
    }

    // Enter Password
    public void enterPassword(String pass) throws InterruptedException {

        Thread.sleep(1000);   // Wait before typing

        slowType(password, pass);
    }

    // Click Login Button
    public void clickLogin() throws InterruptedException {

        Thread.sleep(1500);   // Wait before clicking

        driver.findElement(loginButton).click();
    }

}