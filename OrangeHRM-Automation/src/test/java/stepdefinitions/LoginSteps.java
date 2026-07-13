package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginSteps {

    LoginPage loginPage =
            new LoginPage(DriverFactory.getDriver());

    @When("User enters Username {string}")
    public void user_enters_username(String username) throws Exception {

        loginPage.enterUsername(username);

    }

    @When("User enters Password {string}")
    public void user_enters_password(String password) throws Exception {

        loginPage.enterPassword(password);

    }

    @When("User clicks Login")
    public void user_clicks_login() throws Exception {

        loginPage.clickLogin();

    }

    @Then("Dashboard should be displayed")
    public void dashboard_should_be_displayed() throws Exception {

        Assert.assertTrue(loginPage.verifyDashboard());

        System.out.println();
        System.out.println("========================================");
        System.out.println("✅ LOGIN SUCCESSFUL");
        System.out.println("========================================");

        Thread.sleep(3000);

    }

}