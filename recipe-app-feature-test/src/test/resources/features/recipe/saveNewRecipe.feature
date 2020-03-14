Feature: Author can save a new recipe in the application

  Background:
    Given Alice has an account

  Scenario: Author can save a new recipe
    Given Alice has logged into the application
    When Alice submits a new recipe like in file "recipe_sample.yml"
    Then Recipe is saved