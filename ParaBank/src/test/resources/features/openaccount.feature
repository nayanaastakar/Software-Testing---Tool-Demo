Feature: Open New Account

  @Banking
  Scenario: Open Savings Account

    Given User opens ParaBank website
    When User enters Login Username "nayana123"
    And User enters Login Password "Password@123"
    And User clicks Login button
    Then User should see Accounts Overview page

    When User clicks Open New Account
    And User selects SAVINGS account
    And User clicks Open Account button
    Then New account should be created successfully