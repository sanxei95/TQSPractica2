Feature: edit user functionality

  Scenario Outline: Edit successfull with user Sr
    Given user is going to log in
    And user logs with username and password
    And user logs in
    And user is on edit profile page
    When user changes <name>, <lastname>, <email>, <birthdate> and <password>
    And user decides he is a Sr.
    And user clicks on save
    Then user is navigated to the edit page updated

    Examples:
      | name | lastname | email | birthdate | password |
      | Oscar | Robledo  | 1460919@uab.cat | 02/09/1998 | Prueba.1 |

  Scenario Outline: Edit successfull with user Sra
    Given user is going to log in
    And user logs with username and password
    And user logs in
    And user is on edit profile page
    When user changes <name>, <lastname>, <email>, <birthdate> and <password>
    And user decides she is a Sra.
    And user clicks on save
    Then user is navigated to the edit page updated

    Examples:
      | name | lastname | email | birthdate | password |
      | Maria | Lopez  | 1460919@uab.cat | 06/12/1993 | Prueba.1 |

  Scenario Outline: Edit fails because password
    Given user is going to log in
    And user logs with username and password
    And user logs in
    And user is on edit profile page
    When user changes <name>, <lastname>, <email>, <birthdate> and <password>
    And user decides he is a Sr.
    And user clicks on save
    Then user still same page because danger notification

    Examples:
      | name | lastname | email | birthdate | password |
      | Oscar | Robledo  | 1460919@uab.cat | 02/09/1998 | Prueba.2 |

  Scenario Outline: Edit fails because special chars in name
    Given user is going to log in
    And user logs with username and password
    And user logs in
    And user is on edit profile page
    When user changes <name>, <lastname>, <email>, <birthdate> and <password>
    And user decides he is a Sr.
    And user clicks on save
    Then user still same page because danger notification

    Examples:
      | name | lastname | email | birthdate | password |
      | Oscar!! | Robledo  | 1460919@uab.cat | 02/09/1998 | Prueba.1 |

  Scenario Outline: Edit fails because special invalid birthday
    Given user is going to log in
    And user logs with username and password
    And user logs in
    And user is on edit profile page
    When user changes <name>, <lastname>, <email>, <birthdate> and <password>
    And user decides he is a Sr.
    And user clicks on save
    Then user still same page because danger notification

    Examples:
      | name | lastname | email | birthdate | password |
      | Oscar | Robledo  | 1460919@uab.cat | 02-09-1998 | Prueba.1 |
