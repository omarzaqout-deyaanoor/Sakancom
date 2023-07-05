Feature: Monitoring reservations through the system

Scenario: View reservation details
Given you are logged into the reservation system
When accessing the reservations dashboard
Then I will be able to view a list of all current reservations
And reservation must display the relevant details of the house such as "House Name" "Reservation Status" "House Picture"