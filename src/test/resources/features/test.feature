Feature: Make My Trip Application
  Validating MMT Application

  @TAG-001
  Scenario: Test to check the MMT Application
    Given user is on MakeMyTrip website
    When user selects From City as "Mumbai" and To City as "Bangalore"
    And clicks on Search Flights