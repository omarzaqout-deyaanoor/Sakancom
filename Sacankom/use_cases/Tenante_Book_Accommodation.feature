
Feature: Book Accommodationn


   Scenario: Book Accommodation with login
    Given login Using tenant
    When  Found house to avilable
    And i have to Book Accommodation
    Then  I Book Accommodation
   
    Scenario: 
    Given login Using tenant
    When Doesnt found house avilable
    Then Null message
 
  Scenario: With out login
    Given doesnt login Using tenant
    When i have to Book Accommodation
    Then Error Message
