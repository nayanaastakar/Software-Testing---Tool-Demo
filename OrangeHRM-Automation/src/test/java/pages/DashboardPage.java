package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    WebDriver driver;
    WebDriverWait wait;

    public DashboardPage(WebDriver driver){

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    //=========================
    // Locators
    //=========================

    By pimMenu = By.xpath("//span[text()='PIM']");

    By dashboard = By.xpath("//h6[text()='Dashboard']");

    //=========================

    public boolean verifyDashboard(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));

        return driver.findElement(dashboard).isDisplayed();

    }

    public void clickPIM() throws Exception{

        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(pimMenu));

        driver.findElement(pimMenu).click();

    }

}