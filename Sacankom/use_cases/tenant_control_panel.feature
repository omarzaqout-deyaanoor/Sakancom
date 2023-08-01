
Feature:  Tenant control panel 
 
 
Scenario: tenant_control_panel 
Given The Tenant is login 
And  i want  tenant control panel  
When booking accommodation to after
Then doneee


Scenario: Not tenant_control_panel  not found
Given The Tenant is login
And  i want  tenant control panel 
When not booking accommodation to after
Then error messages not donee "can not done because not booking"


Scenario: Not tenant_control_panel 
Given The Tenant is not loginnn
And  i want  tenant control panel 
Then error messages not done not login "can not done because the tenant is not login"
