Feature:Fleet management
  As a user, I should be accessing all the main modules of the app.

  Background: For the scenarios in the feature file, user is expected to be on login page
    Given user is on the library login page

  @smoke @u1
  Scenario: As a user, I should be accessing all the main modules of the app.
    When Store and sales manager login
    Then  They see eight modules
      | Dashboards       |
      | Fleet            |
      | Customers        |
      | Sales            |
      | Activities       |
      | Marketing        |
      | Report & Segment |
      | System           |



  @smoke @u1
  Scenario:  As a user, I should be accessing 4 the main modules of the app.
    When Driver need to see 4 modules
    Then Verify the users see 4 modules: Fleet, Customers, Activities, System

      | Fleet      |
      | Customers  |
      | Activities |
      | System     |


  @smoke @u2
  Scenario: As a user, I should be access to the Oroinc Documentation page. (Window handle)
    When Store and sales manager login
    When  User on the homepage
    And User click Oronic Documentation page
    Then Verify the users access to the Oronic Documentation page

    @smoke @u3
    Scenario: As a user, I want to learn how to use the pinbar.
      When Store and sales manager login
      When User click to pinbar
      And  User verify  image source
      And  User verify text message

      @wip
    Scenario:  As a user, I want to access to Vehicle contracts page
      When Store and sales manager login
      When Click the "Vehicle Contracts" under the Fleet
      Then Verify managers can access the Vehicle contracts page



