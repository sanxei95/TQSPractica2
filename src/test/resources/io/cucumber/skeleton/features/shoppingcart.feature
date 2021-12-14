Feature: test shopping cart functionality

  Scenario: add a product to the shopping cart and start shopping process
    Given user is on products page
    And user accept cookies
    And clicks on first product
    And verify product in the shopping cart
    When user press end buy
    Then user is redirected to payment process


  Scenario: delete product from the shopping cart (cart has 1 product)
    Given user is on products page
    And user accept cookies
    And clicks on first product
    And verify product in the shopping cart
    And user is on the shopping cart page
    When user press delete button
    Then product is no longer in shopping cart

  Scenario: add a product to the shopping and increment its units
    Given a
    When b
    Then c








