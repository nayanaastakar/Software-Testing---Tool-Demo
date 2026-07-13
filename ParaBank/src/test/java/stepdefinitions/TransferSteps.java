package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TransferPage;
import utils.DriverFactory;

public class TransferSteps {

    TransferPage transferPage =
            new TransferPage(DriverFactory.getDriver());

    @When("User clicks Transfer Funds")
    public void user_clicks_transfer_funds()
            throws Exception {

        Thread.sleep(3000);

        transferPage.clickTransferFunds();

    }

    @When("User enters Amount {string}")
    public void user_enters_amount(String amount)
            throws Exception {

        transferPage.enterAmount(amount);

        Thread.sleep(2000);

    }

    @When("User clicks Transfer button")
    public void user_clicks_transfer_button()
            throws Exception {

        transferPage.selectFromAccount();

        Thread.sleep(1000);

        transferPage.selectToAccount();

        Thread.sleep(1000);

        transferPage.clickTransferButton();

    }

    @Then("Transfer should be successful")
    public void transfer_should_be_successful()
            throws Exception {

        Assert.assertTrue(transferPage.verifyTransfer());

        System.out.println();
        System.out.println("======================================");
        System.out.println("💸 MONEY TRANSFER SUCCESSFUL");
        System.out.println("======================================");

        Thread.sleep(5000);

    }

}