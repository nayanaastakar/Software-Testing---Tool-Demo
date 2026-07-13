package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.OpenAccountPage;
import utils.DriverFactory;

public class OpenAccountSteps {

    OpenAccountPage accountPage =
            new OpenAccountPage(DriverFactory.getDriver());

    @When("User clicks Open New Account")
    public void user_clicks_open_new_account() throws Exception {

        Thread.sleep(2000);

        accountPage.clickOpenAccount();

    }

    @When("User selects {string} account")
    public void user_selects_account(String accountType)
            throws Exception {

        Thread.sleep(2000);

        accountPage.selectAccountType(accountType);

    }

    @When("User clicks Open Account button")
    public void user_clicks_open_account_button()
            throws Exception {

        Thread.sleep(2000);

        accountPage.clickOpenAccountButton();

    }

    @Then("New account should be created successfully")
    public void new_account_should_be_created_successfully()
            throws Exception {

        Assert.assertTrue(accountPage.verifyAccountCreated());

        Thread.sleep(5000);

    }

}