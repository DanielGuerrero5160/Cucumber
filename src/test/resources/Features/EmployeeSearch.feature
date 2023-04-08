Feature: Searching the employee

  Background:
    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM option

  @smoke1
  Scenario: Search Employee by ID
    #Given open the browser and launch HRMS application
    #When user enters valid email and valid password
    #And click on login button
    #When user clicks on PIM option
    When user enters valid employee ID
    And clicks on search button
    And user sees employee information displayed
   # And Close the browser

    @smoke1
    Scenario: Search Employee by job title
    #  Given open the browser and launch HRMS application
     # When user enters valid email and valid password
      #And click on login button
      #When user clicks on PIM option
     When user selects job title
      And clicks on search button
      And user sees employee information displayed
      #And Close the browser