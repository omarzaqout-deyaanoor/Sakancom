Feature: view avilable house

 
  Scenario: available house with login
    Given login using tenant
    When  found house avilable
    Then show houses avilability
      
   Scenario: 
    Given login using tenant
    When doesnt found house avilable
    Then null message
 
  Scenario: with out login
    Given doesnt login using tenant
    When i have to show house
    Then error message
   
   
