Feature: Modify housing data

Scenario: Changing the name of the housing unit
Given I run a residential unit
When i need to update module name
Then I should be able to name the module.

Scenario: Changing the name of the housing unit
Given I run a residential unit
When i need to update module name
And the name of the unit is exist
Then  it fails

Scenario: Changing housing unit availability
Given I run a residential unit
When I need to update module availability
Then I should be able to mark the module as available or unavailable for specific dates or date ranges.



Scenario: Updating the housing unit photos
Given I run a residential unit
When I want to update unit images
Then I should be able to replace or load new images, showing the unit's features and appearance.

Scenario: Housing unit pricing adjustment
Given I run a residential unit
When I need to modify pricing information for a unit
Then I should be able to update pricing, seasonal pricing, or any other relevant pricing details.

Scenario: Modifying the location of the housing unit
Given I run a residential unit
When I want to add, remove or update the site linked to the module
Then  I should be able to edit the location .


Scenario: Save changes to housing data
Given I made adjustments to the housing unit data
When you have reviewed and finalized the changes
Then I should be able to save the modifications and ensure that the updated data is reflected in the system.