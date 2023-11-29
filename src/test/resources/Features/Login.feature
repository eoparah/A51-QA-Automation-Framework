Feature: Login feature

  Scenario: Login Success
    Given I open Login Page
    When I enter email "demo@class.com"
    And I enter password "te$tStudent"
    And I submit
    Then I should get logged in

