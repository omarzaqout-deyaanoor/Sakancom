Feature: adding and advertising residential units through the system


Scenario: add housing done
Given the admin is log 
And  i want to add the house  
When add house
Then add done 


Scenario: 
Given the admin is not login
And   i want to add the house
When add house
Then error message "can not add becouse the admin is not login"