Feature: ParaBank Login

  @Negative
  Scenario: Login with invalid credentials

    Given User opens ParaBank website
    When User enters Login Username "wronguser"
    And User enters Login Password "wrongpassword"
    And User clicks Login button
    Then Error message should be displayed

  @Positive
  Scenario: Login with valid credentials

    Given User opens ParaBank website
    When User enters Login Username "nayana123"
    And User enters Login Password "Password@123"
    And User clicks Login button
    Then User should see Accounts Overview page