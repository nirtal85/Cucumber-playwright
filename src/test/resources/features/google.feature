Ability: Login

  Background:
    Given I navigate to "https://the-internet.herokuapp.com/"

  Scenario: Add Elements
    And I click on "Add/Remove Elements"
    And I click on "Add Element" 7 times
    Then 7 elements are visible

  Scenario: Remove Elements
    And I click on "Add/Remove Elements"
    And I click on "Add Element" 7 times
    And I click on "Delete" 7 times
    Then 0 elements are visible