Feature: Employee Management

  @Regression
  Scenario: Add Employee

    Given User opens OrangeHRM website

    When User enters Username "Admin"

    And User enters Password "admin123"

    And User clicks Login

    Then Dashboard should be displayed

    When User clicks PIM

    And User clicks Add Employee

    And User enters First Name "Nayana"

    And User enters Last Name "Astakar"

    And User clicks Save

    Then Employee should be added successfully