Feature: Login Functionalities
  @smoke
  Scenario: Valid Admin Login
    #Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    Then user is logged in successfully into the application
    #And Close the browser


  @smoke2
  Scenario: Valid Admin Login
    #Given open the browser and launch HRMS application
    When user enters valid "Admin1" and valid "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully into the application
    #And Close the browser

    #we can write notes here

  #HOOKS: For defining pre and post steps in any Cucumber Framework
   #      : This is always created inside StepDefinition folder
   #     : This class cannot be inherited