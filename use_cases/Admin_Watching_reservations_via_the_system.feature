Feature: reservations through the system

Scenario: Watching reservations
    Given admin is login to watch
    When i want to Watching reservations
    Then show 


Scenario: Watching reservations222
    Given admin is login to watch
    When i want to Watching reservations but not found
    Then message not found "not found"
    
    
  Scenario: not Watching reservations
    Given admin is not login to watch
    When i want to Watching reservations
    Then erorr mas "Admin not login"