package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;

public class Hooks {

    @Before
    public void setup() {

        DriverFactory.initializeDriver();

    }

    @After
    public void tearDown() {

        DriverFactory.quitDriver();

    }

}