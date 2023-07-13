Feature: login

  
  Scenario: login success
    Given the user_name is "omar"
    And the password is "321" 
    When  accept
    Then login success
    And Done 
    And Welcome

  
  Scenario: login faild the user_name is wrong
    Given the user_name is "deyaa"
    And the password is "321" 
    When dont accept
    Then login faild
    And sorry, try again 
    
  
  Scenario: login faild the password is wrong
    Given the user_name is "omar"
    And the password is "123" 
    Then login faild
    And sorry, try again
    
   
  Scenario: login faild the password and user_name are wrong 
    Given the user_name is "deyaa"
    And the password is "123" 
    Then login faild
    And sorry, try again
    