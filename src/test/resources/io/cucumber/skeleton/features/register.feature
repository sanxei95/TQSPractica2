Feature: test register functionality

  Scenario Outline: Register fails because mail already exists.
    Given user is on the register site
    When user writes the form with <name> and <lastname> and <email> and <password> and <date>
    And accepts client privacy
    And clicks on register
    Then gets an email already exists error message

    Examples:
      | name                | lastname   | email | password | date |
      | Xavi                | Sancho     | xaviersanchor@gmail.com | Pepapig.95 | 26/01/95 |

  Scenario Outline: Register fails due invalid characters in name field.
    Given user is on the register site
    When user writes the form with <name> and <lastname> and <email> and <password> and <date>
    And accepts client privacy
    And clicks on register
    Then gets a format error message

    Examples:
      | name                | lastname   | email | password | date |
      | r2d2               | Sancho     | 1460919@gmail.com | Pepapig.95 | 26/01/95 |

  Scenario Outline: Register fails due invalid date in date field.
    Given user is on the register site
    When user writes the form with <name> and <lastname> and <email> and <password> and <date>
    And accepts client privacy
    And clicks on register
    Then gets a date format error message

    Examples:
      | name                | lastname   | email | password | date |
      | r2d2               | Sancho     | 1460919@gmail.com | Pepapig.95 | buenosdias |
