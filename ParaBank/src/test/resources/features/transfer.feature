Feature: Transfer Funds

  @Regression
  Scenario: Transfer money between accounts

    Given User opens ParaBank website
    When User enters Login Username "nayana123"
    And User enters Login Password "Password@123"
    And User clicks Login button
    Then User should see Accounts Overview page

    When User clicks Transfer Funds
    And User enters Amount "100"
    And User clicks Transfer button
    Then Transfer should be successful