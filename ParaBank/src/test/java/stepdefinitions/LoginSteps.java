package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.DriverFactory;

public class LoginSteps {

    LoginPage loginPage =
            new LoginPage(DriverFactory.getDriver());

    // ==========================
    // Username
    // ==========================

    @When("User enters Login Username {string}")
    public void user_enters_login_username(String username) throws Exception {

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Typing Username");
        System.out.println("----------------------------------------");

        // If feature file says GENERATED_USERNAME,
        // use the username created during registration.
        if(username.equalsIgnoreCase("GENERATED_USERNAME")){

            username = RegistrationPage.generatedUsername;

        }

        loginPage.enterUsername(username);

        Thread.sleep(1000);
    }

    // ==========================
    // Password
    // ==========================

    @When("User enters Login Password {string}")
    public void user_enters_login_password(String password) throws Exception {

        System.out.println("----------------------------------------");
        System.out.println("Typing Password");
        System.out.println("----------------------------------------");

        loginPage.enterPassword(password);

        Thread.sleep(1000);
    }

    // ==========================
    // Login
    // ==========================

    @When("User clicks Login button")
    public void user_clicks_login_button() throws Exception {

        System.out.println("----------------------------------------");
        System.out.println("Clicking Login");
        System.out.println("----------------------------------------");

        loginPage.clickLogin();

        Thread.sleep(3000);

        System.out.println("Current URL : "
                + DriverFactory.getDriver().getCurrentUrl());
    }

    // ==========================
    // Invalid Login
    // ==========================

    @Then("Error message should be displayed")
    public void error_message_should_be_displayed() throws Exception {

        Assert.assertTrue(loginPage.verifyErrorMessage());

        System.out.println();
        System.out.println("=======================================");
        System.out.println("❌ INVALID LOGIN VERIFIED");
        System.out.println("=======================================");

        Thread.sleep(4000);
    }

    // ==========================
    // Valid Login
    // ==========================

    @Then("User should see Accounts Overview page")
    public void user_should_see_accounts_overview_page() throws Exception {

        Assert.assertTrue(loginPage.verifyLogin());

        System.out.println();
        System.out.println("=======================================");
        System.out.println("✅ LOGIN SUCCESSFUL");
        System.out.println("=======================================");

        Thread.sleep(4000);
    }

}