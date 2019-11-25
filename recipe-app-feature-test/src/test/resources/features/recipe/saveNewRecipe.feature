Feature: Author can save a new recipe in the application

  Background:
    Given Alice has an account

  Scenario: Author can save a new recipe when recipe has a name
    Given Alice has logged into the application
    When Alice submits a new recipe
    Then Recipe is saved