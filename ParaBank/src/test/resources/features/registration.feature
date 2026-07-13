Feature: User Registration

  @Smoke
  Scenario: Register New User

    Given User opens ParaBank website
    When User clicks Register
    And User enters First Name "Nayana"
    And User enters Last Name "Astakar"
    And User enters Address "Bangalore"
    And User enters City "Bangalore"
    And User enters State "Karnataka"
    And User enters Zip Code "560001"
    And User enters Phone "9876543210"
    And User enters SSN "123456789"
    And User enters Username "nayana123"
    And User enters Password "Password@123"
    And User confirms Password "Password@123"
    And User clicks Register button
    Then Registration should be successful