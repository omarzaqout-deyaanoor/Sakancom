Feature: adding furniture


Scenario: add furniture done
Given the tenant is log 
And  i want to adding the furniture  
When adding furniture
Then Adding done 


Scenario:
Given the tenant is not login
And   i want to adding the furniture
When adding furniture
Then error Messages "can not adding because the tenant is not login"