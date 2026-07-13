package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utils.DriverFactory;

public class CommonSteps {

    @Given("User opens ParaBank website")
    public void user_opens_para_bank_website() throws InterruptedException {

        System.out.println();
        System.out.println("==============================================");
        System.out.println("🌐 Opening ParaBank Website...");
        System.out.println("==============================================");

        // Small delay so audience can see homepage
        Thread.sleep(3000);

        String currentUrl = DriverFactory.getDriver().getCurrentUrl();

        Assert.assertTrue(
                "ParaBank website did not open correctly",
                currentUrl.contains("parabank")
        );

        System.out.println("✅ ParaBank Website Loaded Successfully");
        System.out.println("Current URL : " + currentUrl);

        Thread.sleep(2000);
    }
}