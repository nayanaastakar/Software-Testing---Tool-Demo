package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver driver;
    public static WebDriverWait wait;

    private DriverFactory() {
        // Prevent object creation
    }

    public static void initializeDriver() {

        if (driver == null) {

            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().deleteAllCookies();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

            wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            driver.get("https://parabank.parasoft.com/");

            System.out.println("==========================================");
            System.out.println("🚀 ParaBank Browser Started Successfully");
            System.out.println("==========================================");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static void quitDriver() {

        if (driver != null) {

            driver.quit();

            driver = null;
            wait = null;

            System.out.println("==========================================");
            System.out.println("🛑 Browser Closed Successfully");
            System.out.println("==========================================");
        }
    }
}