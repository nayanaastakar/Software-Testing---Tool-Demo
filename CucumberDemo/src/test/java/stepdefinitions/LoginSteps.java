package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginSteps {

    LoginPage loginPage;
    CartPage cartPage;

    @Given("User opens SauceDemo website")
    public void user_opens_saucedemo_website() {

        loginPage = new LoginPage(DriverFactory.driver);
        cartPage = new CartPage(DriverFactory.driver);

    }

    @When("User enters username {string}")
    public void user_enters_username(String username) throws InterruptedException {

        loginPage.enterUsername(username);

    }

    @When("User enters password {string}")
    public void user_enters_password(String password) throws InterruptedException {

        loginPage.enterPassword(password);

    }

    @When("User clicks Login button")
    public void user_clicks_login_button() throws InterruptedException {

        loginPage.clickLogin();

    }

    @Then("User should see Products page")
    public void user_should_see_products_page() {

        Assert.assertTrue(
                DriverFactory.driver.getCurrentUrl().contains("inventory")
        );

        System.out.println("✅ Login Successful");

    }

    @When("User adds Backpack to cart")
    public void user_adds_backpack_to_cart() throws InterruptedException {

        cartPage.addBackpack();

        boolean added = cartPage.verifyAdded();
        boolean badge = cartPage.verifyCartBadge();

        System.out.println("Remove Button Present : " + added);
        System.out.println("Cart Badge Present    : " + badge);

        Assert.assertTrue(badge);

        System.out.println("✅ Product Added Successfully");
    }

    @When("User opens Cart")
    public void user_opens_cart() throws InterruptedException {

        cartPage.openCart();

        System.out.println("✅ Cart Opened");
    }
    @When("User clicks Checkout")
    public void user_clicks_checkout() {

        cartPage.clickCheckout();

    }

    @When("User enters First Name {string}")
    public void user_enters_first_name(String fname) {

        cartPage.enterFirstName(fname);

    }

    @When("User enters Last Name {string}")
    public void user_enters_last_name(String lname) {

        cartPage.enterLastName(lname);

    }

    @When("User enters Postal Code {string}")
    public void user_enters_postal_code(String code) {

        cartPage.enterPostalCode(code);

    }

    @When("User clicks Continue")
    public void user_clicks_continue() throws InterruptedException {

        cartPage.clickContinue();

    }

    @When("User clicks Finish")
    public void user_clicks_finish() throws InterruptedException {

        cartPage.clickFinish();

    }

    @Then("Order should be placed successfully")
    public void order_should_be_placed_successfully() {

        Assert.assertTrue(cartPage.verifyOrder());

        System.out.println("✅ Order Placed Successfully");

    }

    @Then("Backpack should be present in Cart")
    public void backpack_should_be_present_in_cart() throws InterruptedException {

        Assert.assertTrue(cartPage.verifyProduct());

        System.out.println("✅ Product Verified Inside Cart");
    }

}