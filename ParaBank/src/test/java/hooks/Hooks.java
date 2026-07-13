package hooks;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import utils.DriverFactory;

public class Hooks {

    @BeforeAll
    public static void setUp() {

        System.out.println();
        System.out.println("==============================================");
        System.out.println("      STARTING PARABANK AUTOMATION DEMO");
        System.out.println("==============================================");

        DriverFactory.initializeDriver();
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {

        System.out.println();
        System.out.println("==============================================");
        System.out.println("      AUTOMATION COMPLETED");
        System.out.println("==============================================");

        // Show final screen before closing
        Thread.sleep(5000);

        DriverFactory.quitDriver();
    }
}