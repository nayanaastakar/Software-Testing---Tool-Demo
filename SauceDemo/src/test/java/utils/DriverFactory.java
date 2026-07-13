package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public static WebDriver driver;

    public static void initializeDriver() {

        String browser = "edge";   // Change this to edge or firefox

        switch (browser.toLowerCase()) {

            case "chrome":

                WebDriverManager.chromedriver().setup();

                ChromeOptions chromeOptions = new ChromeOptions();

                chromeOptions.addArguments("--start-maximized");

                driver = new ChromeDriver(chromeOptions);

                break;

            case "edge":

                System.setProperty(
                        "webdriver.edge.driver",
                        "C:\\edgedriver_win64\\msedgedriver.exe"
                );

                EdgeOptions edgeOptions = new EdgeOptions();

                driver = new EdgeDriver(edgeOptions);

                driver.manage().window().maximize();

                break;

            case "firefox":

                WebDriverManager.firefoxdriver().setup();

                FirefoxOptions firefoxOptions = new FirefoxOptions();

                driver = new FirefoxDriver(firefoxOptions);

                driver.manage().window().maximize();

                break;

            default:

                throw new RuntimeException("Invalid Browser");

        }

        driver.get("https://www.saucedemo.com/");

    }

    public static void quitDriver() {

        if (driver != null) {

            driver.quit();

        }

    }

}