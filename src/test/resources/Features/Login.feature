Feature: Login Functionalities
  Scenario: Valid Admin Login
    Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    Then user is logged in successfully into the application
    And Close the browser