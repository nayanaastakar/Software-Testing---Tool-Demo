package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.RegistrationPage;
import utils.DriverFactory;

public class RegistrationSteps {

    RegistrationPage registrationPage =
            new RegistrationPage(DriverFactory.getDriver());

    @When("User clicks Register")
    public void user_clicks_register() throws Exception {

        System.out.println();
        System.out.println("========================================");
        System.out.println("Opening Registration Page");
        System.out.println("========================================");

        registrationPage.clickRegister();

        Thread.sleep(2000);
    }

    @When("User enters First Name {string}")
    public void user_enters_first_name(String firstName) throws Exception {

        registrationPage.enterFirstName(firstName);

    }

    @When("User enters Last Name {string}")
    public void user_enters_last_name(String lastName) throws Exception {

        registrationPage.enterLastName(lastName);

    }

    @When("User enters Address {string}")
    public void user_enters_address(String address) throws Exception {

        registrationPage.enterAddress(address);

    }

    @When("User enters City {string}")
    public void user_enters_city(String city) throws Exception {

        registrationPage.enterCity(city);

    }

    @When("User enters State {string}")
    public void user_enters_state(String state) throws Exception {

        registrationPage.enterState(state);

    }

    @When("User enters Zip Code {string}")
    public void user_enters_zip_code(String zip) throws Exception {

        registrationPage.enterZipCode(zip);

    }

    @When("User enters Phone {string}")
    public void user_enters_phone(String phone) throws Exception {

        registrationPage.enterPhone(phone);

    }

    @When("User enters SSN {string}")
    public void user_enters_ssn(String ssn) throws Exception {

        registrationPage.enterSSN(ssn);

    }

    @When("User generates Username")
    public void user_generates_username() throws Exception {

        registrationPage.enterUsername();

        Thread.sleep(1000);

    }

    @When("User enters Password {string}")
    public void user_enters_password(String password) throws Exception {

        registrationPage.enterPassword(password);

    }

    @When("User confirms Password {string}")
    public void user_confirms_password(String password) throws Exception {

        registrationPage.confirmPassword(password);

    }

    @When("User clicks Register button")
    public void user_clicks_register_button() throws Exception {

        Thread.sleep(2000);

        registrationPage.clickRegisterButton();

    }

    @Then("Registration should be successful")
    public void registration_should_be_successful() throws Exception {

        Assert.assertTrue(registrationPage.verifyRegistration());

        System.out.println();
        System.out.println("========================================");
        System.out.println("✅ REGISTRATION SUCCESSFUL");
        System.out.println("========================================");

        System.out.println("Generated Username : "
                + RegistrationPage.generatedUsername);

        Thread.sleep(5000);
    }

}