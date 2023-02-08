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
      | Reports & Segments |
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

  @smoke @u4
  Scenario:  As a manager, I want to access to Vehicle contracts page
    When Store and sales manager login
    When Click the "Vehicle Contracts" under the Fleet
    Then Verify managers can access the Vehicle contracts page


  Scenario: Drivers can NOT access the Vehicle contracts page
    When Driver need to see 4 modules
    And Driver click Vehicle Contracts modul
    Then Driver should not get module

  @U5
  Scenario:  As a user, I want to view columns on the Vehicle models page.(web-table)
    When Store and sales manager login
    And User click dropdone "Fleet"
    And User click altdown "Vehicles Models"
    Then User verify table columns.
      | MODEL NAME               |
      | MAKE                     |
      | CAN BE REQUESTED         |
      | CVVI                     |
      | CO2 FEE (/MONTH)         |
      | COST (DEPRECIATED)       |
      | TOTAL COST (DEPRECIATED) |
      | CO2 EMISSIONS            |
      | FUEL TYPE                |
      | VENDORS                  |

  @Us6
  Scenario:   As a user, I want to see edit car info icons from the Vehicle page.
    When Store and sales manager login
    And User click dropdone "Fleet"
    And User click altdown Vehicles
    And Verify any car info has 3 dots


  Scenario:  As a user, I should be to select any vehicle from the Vehicle page(web-table)
    When Store and sales manager login
    And User click dropdone "Fleet"
    And User click altdown Vehicles
    And  Verify all checkboxes  unchecked
    And  User checks the first checkbox to check all the cars
    And Check any car’s checkbox
    And  Verify the box is checked

  @wip
  Scenario:  As a user, I want to create a recurring(repetitive) calendar event.
    When Store and sales manager login
    When Click the “Calendar Events” under the Activities
    And  Click the “Create Calendar Event” button
    And Check the Repeat checkbox
    And Verify the repeat number is One

