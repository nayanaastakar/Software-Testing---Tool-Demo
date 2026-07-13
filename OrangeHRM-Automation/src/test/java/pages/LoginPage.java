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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    //=========================
    // Locators
    //=========================

    By username = By.name("username");

    By password = By.name("password");

    By loginButton = By.xpath("//button[@type='submit']");

    By dashboard = By.xpath("//h6[text()='Dashboard']");

    //=========================
    // Slow Typing Method
    //=========================

    private void slowType(By locator, String text) throws Exception {

        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        element.clear();

        for(char c : text.toCharArray()){

            element.sendKeys(String.valueOf(c));

            Thread.sleep(150);

        }

    }

    //=========================

    public void enterUsername(String user) throws Exception {

        slowType(username,user);

    }

    public void enterPassword(String pass) throws Exception {

        slowType(password,pass);

    }

    public void clickLogin() throws Exception {

        Thread.sleep(2000);

        driver.findElement(loginButton).click();

    }

    public boolean verifyDashboard(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));

        return driver.findElement(dashboard).isDisplayed();

    }

}