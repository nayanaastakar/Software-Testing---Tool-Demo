package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LogoutPage;
import utils.DriverFactory;

public class LogoutSteps {

    LogoutPage logoutPage =
            new LogoutPage(DriverFactory.getDriver());

    @When("User clicks Logout")
    public void user_clicks_logout() throws Exception {

        System.out.println();
        System.out.println("=====================================");
        System.out.println("Logging Out...");
        System.out.println("=====================================");

        Thread.sleep(2000);

        logoutPage.clickLogout();

    }

    @Then("Login page should be displayed")
    public void login_page_should_be_displayed() throws Exception {

        Assert.assertTrue(logoutPage.verifyLogout());

        System.out.println();
        System.out.println("=====================================");
        System.out.println("✅ LOGOUT SUCCESSFUL");
        System.out.println("=====================================");

        Thread.sleep(3000);

    }

}