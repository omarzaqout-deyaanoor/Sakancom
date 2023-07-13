Feature: Advertisement Requests for Housing


  Scenario: Accepting a Housing Advertisement Request
    Given admin is login
    When the administrator reviews the request
    And the request is Accept
    Then the advertisement for the housing property should be published

  Scenario: Rejecting a Housing Advertisement Request
    Given admin is login
    When the administrator reviews the request
    And the requests is reject
    Then the advertisement for the housing property should not be published