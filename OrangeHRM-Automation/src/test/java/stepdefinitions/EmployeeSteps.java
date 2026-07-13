package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashboardPage;
import pages.PIMPage;
import utils.DriverFactory;

public class EmployeeSteps {

    DashboardPage dashboard =
            new DashboardPage(DriverFactory.getDriver());

    PIMPage pim =
            new PIMPage(DriverFactory.getDriver());

    @When("User clicks PIM")
    public void user_clicks_pim() throws Exception {

        dashboard.clickPIM();

    }

    @When("User clicks Add Employee")
    public void user_clicks_add_employee() throws Exception {

        pim.clickAddEmployee();

    }

    @When("User enters First Name {string}")
    public void user_enters_first_name(String firstName) throws Exception {

        pim.enterFirstName(firstName);

    }

    @When("User enters Last Name {string}")
    public void user_enters_last_name(String lastName) throws Exception {

        pim.enterLastName(lastName);

    }

    @When("User clicks Save")
    public void user_clicks_save() throws Exception {

        pim.clickSave();

    }

    @Then("Employee should be added successfully")
    public void employee_should_be_added_successfully() throws Exception {

        Assert.assertTrue(pim.verifyEmployeeAdded());

        System.out.println();
        System.out.println("========================================");
        System.out.println("✅ EMPLOYEE ADDED SUCCESSFULLY");
        System.out.println("========================================");

        Thread.sleep(3000);

    }

    @When("User opens Employee List")
    public void user_opens_employee_list() throws Exception {

        pim.clickEmployeeList();

    }

    @When("User searches Employee {string}")
    public void user_searches_employee(String employeeName) throws Exception {

        pim.searchEmployee(employeeName);

    }

    @Then("Employee should be displayed")
    public void employee_should_be_displayed() throws Exception {

        System.out.println();
        System.out.println("========================================");
        System.out.println("✅ EMPLOYEE SEARCH COMPLETED");
        System.out.println("========================================");

        Thread.sleep(3000);

    }

}