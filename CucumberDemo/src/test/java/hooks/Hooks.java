package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;

public class Hooks {

    @Before
    public void setUp() {

        DriverFactory.initializeDriver();

    }

    @After
    public void tearDown() throws InterruptedException {

        Thread.sleep(10000);   // Browser remains open for 10 seconds

        DriverFactory.quitDriver();

    }
}