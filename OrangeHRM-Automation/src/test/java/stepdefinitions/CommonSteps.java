package stepdefinitions;

import io.cucumber.java.en.Given;
import utils.DriverFactory;

public class CommonSteps {

    @Given("User opens OrangeHRM website")
    public void user_opens_orangehrm_website() throws Exception {

        System.out.println();
        System.out.println("========================================");
        System.out.println("🌐 Opening OrangeHRM Website");
        System.out.println("========================================");

        DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(4000);

        System.out.println("✅ Website Loaded Successfully");
        System.out.println(DriverFactory.getDriver().getCurrentUrl());

    }

}