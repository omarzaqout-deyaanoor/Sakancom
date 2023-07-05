Feature: adding and advertising residential units through the system

Scenario: Adding a new housing unit
Given I am logged into the system as a property manager
When he moved to the Department of Housing Unit Management
Then I will be able to add a new housing unit by providing details such as "housing picture" "housing name" "location" "available services" "price" "contact information" "determine unit availability"

Scenario: Presentation of residential units on the site
Given I have added and configured the condominiums in the system
When potential guests visit the site
Then they should be able to view available condominiums along with relevant details, such as unit type, description, amenities, and photos.