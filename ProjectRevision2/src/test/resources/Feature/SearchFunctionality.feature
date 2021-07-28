Feature: Validate Search functionality

  Background: user open the browser
    Given user launches the browser

  Scenario: User can validate all the search results on first page contain search term entered
    When User search an item using search option
    Then Validate all search results are according to the item searched

  Scenario: User can open the last image appearing on image search results for any search term entered
    When User search an item & opens Image search results
    Then User scroll down & click on last image
