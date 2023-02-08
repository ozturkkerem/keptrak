Feature: Dashboard

  Background: User on the login page
    Given user is on the library login page

  Scenario: As a user, I want to see edit car info icons from the Vehicle page.
    When  User click dropdone "Fleet"
    When User click altdown Vehicles
