Feature: Validate Login functionality using sign in option on homepage

  Background: user open the browser
    Given user launches the browser

  Scenario: User should be able to login with valid credentials
    When user enter valid mailid and valid password
    Then user should be able to login successfully

  Scenario: User should not be able to login with invalid credentials
    When user enter valid mailid and invalid password
    Then user should not be able to login successfully
