Feature: Cart Functionality

  @Regression
  Scenario: Complete Checkout

    Given User opens SauceDemo website
    When User enters username "standard_user"
    And User enters password "secret_sauce"
    And User clicks Login button
    Then User should see Products page

    And User adds Backpack to cart
    And User opens Cart
    Then Backpack should be present in Cart

    When User clicks Checkout
    And User enters First Name "Nayana"
    And User enters Last Name "RA"
    And User enters Postal Code "560001"
    And User clicks Continue
    And User clicks Finish
    Then Order should be placed successfully