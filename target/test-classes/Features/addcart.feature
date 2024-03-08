Feature: add to cart automation of flipkart

  Scenario: add to cart scenario
    Given user is on home page
    When user searh product in search bar
    And select the products click on add to cart
    Then user should see product in cart
    And validates the product
