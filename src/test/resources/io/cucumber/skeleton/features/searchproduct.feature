Feature: test search product functionality

  Scenario Outline: search a product pressing search button
    Given user is on the main page
    When user <input> in search field
    And user clicks on search button
    Then user is navigated to the search result page

    Examples:
    | input |
    | 3060 |

  Scenario Outline: search empty input pressing search button
    Given user is on the main page
    When user <input> in search field
    And user clicks on search button
    Then user is navigated to the search result page

    Examples:
      | input |
      | |

  Scenario Outline: search empty input ENTER key
    Given user is on the main page
    When user <input> in search field
    And user press ENTER
    Then user is navigated to the search result page

    Examples:
      | input |
      | |