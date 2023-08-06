Feature: Control Panel

  Scenario: view housing
    Given login using owner 
    When select houses
    Then complete view


  Scenario: dosnt login
    Given doesnt login using owner
    When select houses
    Then failed login owner

