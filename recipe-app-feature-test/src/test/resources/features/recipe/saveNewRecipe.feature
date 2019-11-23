Feature: Author can save a new recipe in the application

  Background: Alice is an author

  Scenario: Author can save a new recipe when recipe has a name
    Given Alice has logged into the application
    When Alice submits a new recipe with a name
    Then Recipe is saved