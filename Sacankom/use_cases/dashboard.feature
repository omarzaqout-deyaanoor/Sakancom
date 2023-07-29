Feature: adding floor and apartments 


Scenario: add floor and apartments 
Given The owner is log 
And  i want to add
When adding floor and apartments 
Then add Done 


Scenario:
Given The owner is not login
And   i want to adding the floor and apartments 
When adding floor and apartments 
Then error messages DB "can not adding because the owner is not login"
