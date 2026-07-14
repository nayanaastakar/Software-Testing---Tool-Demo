package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PIMPage {

    WebDriver driver;
    WebDriverWait wait;

    public PIMPage(WebDriver driver){

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    //=========================
    // Locators
    //=========================

    By addEmployeeButton =
            By.xpath("//a[text()='Add Employee']");

    By firstName =
            By.name("firstName");

    By lastName =
            By.name("lastName");

    By employeeId =
            By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");

    By saveButton =
            By.xpath("//button[@type='submit']");

    By personalDetails =
            By.xpath("//h6[text()='Personal Details']");

    By employeeList =
            By.xpath("//a[text()='Employee List']");

    By employeeSearch =
            By.xpath("(//input[@placeholder='Type for hints...'])[1]");

    //=========================
    // Slow Typing
    //=========================

    private void slowType(By locator,String value) throws Exception{

        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        element.clear();

        for(char c : value.toCharArray()){

            element.sendKeys(String.valueOf(c));

            Thread.sleep(150);

        }

    }

    //=========================

    public void clickAddEmployee() throws Exception{

        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(addEmployeeButton));

        driver.findElement(addEmployeeButton).click();

    }

    public void enterFirstName(String name) throws Exception{

        slowType(firstName,name);

    }

    public void enterLastName(String name) throws Exception{

        slowType(lastName,name);

    }

    public void clickSave() throws Exception{

        Thread.sleep(2000);

        driver.findElement(saveButton).click();

    }

    public boolean verifyEmployeeAdded() {

        try {

            wait.until(ExpectedConditions.urlContains("viewPersonalDetails"));

            return true;

        } catch (Exception e) {

            return false;

        }

    }

    public void clickEmployeeList() throws Exception{

        Thread.sleep(2000);

        driver.findElement(employeeList).click();

    }

    public void searchEmployee(String name) throws Exception{

        slowType(employeeSearch,name);

        driver.findElement(employeeSearch).sendKeys(Keys.ENTER);

    }

}