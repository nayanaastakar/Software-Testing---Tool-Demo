package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverFactory {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void initializeDriver() {

        if(driver == null){

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            options.setPageLoadStrategy(PageLoadStrategy.EAGER);

            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-gpu");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));

            wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        }

    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static WebDriverWait getWait(){
        return wait;
    }

    public static void quitDriver(){

        if(driver!=null){

            driver.quit();
            driver=null;
            wait=null;

        }

    }

}