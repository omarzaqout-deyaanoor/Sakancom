Feature: Advertisement Requests for Housing

  Scenario: Requesting to Advertise a Housing Property
    Given a user wants to advertise a housing property
    When the user fills in the advertisement request form with the property details
    And submits the request
    Then the request should be sent to the administrator for review
    And the user should receive a confirmation message

  Scenario: Accepting a Housing Advertisement Request
    Given an advertisement request for a housing property is pending 
    When the administrator reviews the request
    And the request is "Accept"
    Then the advertisement for the housing property should be published
    And the user who requested the advertisement should be notified of the acceptance

  Scenario: Rejecting a Housing Advertisement Request
    Given an advertisementt requestt for a housing propertty is pendingg
    When the administratorr reviewss the requestt
    And the requests is "reject"
    Then the advertisement for the housing property should not be published
    And the user who requested the advertisement should be notified of the rejection