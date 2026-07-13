Feature: Complete Banking Automation Demo

  @Demo
  Scenario: Complete Banking Automation

    Given User opens ParaBank website

    #################################################
    # Registration
    #################################################

    When User clicks Register
    And User enters First Name "Nayana"
    And User enters Last Name "R A"
    And User enters Address "Bangalore"
    And User enters City "Bangalore"
    And User enters State "Karnataka"
    And User enters Zip Code "560001"
    And User enters Phone "9876543210"
    And User enters SSN "123456789"
    And User generates Username
    And User enters Password "Password@123"
    And User confirms Password "Password@123"
    And User clicks Register button
    Then Registration should be successful

    #################################################
    # Open Savings Account
    #################################################

    When User clicks Open New Account
    And User selects "SAVINGS" account
    And User clicks Open Account button
    Then New account should be created successfully

    #################################################
    # Transfer Funds
    #################################################

    When User clicks Transfer Funds
    And User enters Amount "100"
    And User clicks Transfer button
    Then Transfer should be successful

    #################################################
    # Logout
    #################################################

    When User clicks Logout
    Then Login page should be displayed