Feature: test login functionality

  Scenario Outline: Log-in with a existing user
    Given user is on login page
    When user enters <username> and <password>
    And user clicks on login
    Then user is navigated to the home page

    Examples:
      | username                | password   |
      | 1460919@uab.cat | Prueba.1 |

  Scenario Outline: Log-in with wrong password
    Given user is on login page
    When user enters <username> and <password>
    And user clicks on login
    Then user doesn't log

    Examples:
      | username                | password   |
      | 1460919@uab.cat | Prueba.2 |

  Scenario Outline: Log-in with wrong username
    Given user is on login page
    When user enters <username> and <password>
    And user clicks on login
    Then user doesn't log

    Examples:
      | username                | password   |
      | xaviersanchorr@gmail.com | Prueba.1 |


