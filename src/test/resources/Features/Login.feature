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

  #Parametrization/Data Driven
@scenarioOutline
  Scenario Outline: Login with multiple credentials using scenario outline
 #Given open the browser and launch HRMS application
    When user enters valid "<username>" and valid "<password>"
    And click on login button
    Then user is logged in successfully into the application
    #And Close the browser
    Examples:
    |username | password |
    | admin   |  Hum@nhrm123 |
    |   ADMIN   | Hum@nhrm123 |
    |   Jason   | Hum@nhrm123 |

  @dataTable
  Scenario: Login with multiple credentials using data table
    When user enters username and password and verifies login
      |username | password |
      | admin   |  Hum@nhrm123 |
      |   ADMIN   | Hum@nhrm123 |
      |   Jason   | Hum@nhrm123 |
