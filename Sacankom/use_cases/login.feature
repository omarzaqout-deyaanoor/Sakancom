Feature: login

  
  Scenario: login success
    Given the user_name is "adham_12028277"
    And the password is "123456789@adham" 
    Then login success
    And Done 
    And Welcome

  
  Scenario: login faild the user_name is wrong
    Given the user_name is "moheeb_12021520"
    And the password is "123456789@adham" 
    Then login faild
    And sorry, try again 
    
  
  Scenario: login faild the password is wrong
    Given the user_name is "adham_12028277"
    And the password is "13597@moheeb" 
    Then login faild
    And sorry, try again
    
   
  Scenario: login faild the password and user_name are wrong 
    Given the user_name is "moheeb_1201262"
    And the password is "13597@moheeb" 
    Then login faild
    And sorry, try again