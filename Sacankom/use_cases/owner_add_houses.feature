Feature: adding houses


Scenario: add housing done
Given the owner is log 
And  i want to adding the house  
When adding houses
Then adding done 


Scenario:
Given the owner is not login
And   i want to adding the house
When adding houses
Then error messages "can not adding because the owner is not login"