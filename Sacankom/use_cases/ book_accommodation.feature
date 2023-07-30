Feature:  Book Accommodation
 


Scenario:  book accommodation
Given the tenant is loginnn 
And  i want to  book accommodation  
When booking accommodation
Then booking done 


Scenario: Not book accommodation not found
Given the tenant is loginnn
And  i want to  book accommodation  
When not found avilabel
Then error messages not book not found "can not booking accommodation because not found avilabel"


Scenario: Not book accommodation
Given the tenant is not loginnn
And  i want to  book accommodation  
Then error messages not book ont login "can not booking accommodation because the tenant is not login"
