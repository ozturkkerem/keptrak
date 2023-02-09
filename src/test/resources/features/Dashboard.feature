Feature: Dashboard

  Background: User on the login page
    Given user is on the library login page

  Scenario: As a user, I want to write the “Description” when I create a calendar event. (Iframe)
    When Store and sales manager login
    When Click the Calendar Events under the Activities.
    And  Click the Create Calendar Event button.
    When  Write a message in the Description field
    Then Verify the message is written in the input box


  Scenario:  As a user, I want to view car odometer info on the Vehicles Odometers page.

    When Store and sales manager login
    And User click dropdone "Fleet"
    And User click altdown Vehicle Odameter
    And Verify the managers see You do not have permission to perform this action.


  Scenario Outline: Story12:  As a user, I want to filter customers’ info on the Account page.
    When Store and sales manager login
    When Click Customers
    When Click Accounts
    Then Verify there are  "<filter options>"
    Examples:
      | filter options |
      | Account Name   |
      | Contact Name   |
      | Contact Email  |
      | Contact Phone  |
      | Owner          |
      | Created At     |
      | Updated At     |


