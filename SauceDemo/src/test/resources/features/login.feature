Feature: Login Functionality

  @Smoke
  Scenario Outline: Login with different users

    Given User opens SauceDemo website
    When User enters username "<username>"
    And User enters password "<password>"
    And User clicks Login button
    Then User should see Products page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |