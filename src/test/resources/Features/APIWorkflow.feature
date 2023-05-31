Feature: API workflow for HRMS

  Background:
    Given a JWT is generated

  @api
  Scenario: Create an employee using API call
   Given a request is prepared to create an employee
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    Then the employee contains key "Message" and value "Employee Created"
    Then the employee id "Employee.employee_id" is stored as a global variable to be used for other calls


@apiJsonWorkflow
Scenario: Create an employee using API call using json payload
  Given a request is prepared to create an employee using Json payload
  When a POST call is made to create an employee
  Then the status code for creating an employee is 201
  Then the employee contains key "Message" and value "Employee Created"
  Then the employee id "Employee.employee_id" is stored as a global variable to be used for other calls


  @dynamic
  Scenario: Create an employee using API call
    Given a request is prepared to create an employee with dynamic data "Daniel", "Guerrero", "Kiran", "M", "1997-07-13", "FullTime", "SDET"
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    Then the employee contains key "Message" and value "Employee Created"
    Then the employee id "Employee.employee_id" is stored as a global variable to be used for other calls

  @dynamic
  Scenario: Retrieve an employee using API call
    Given a request is prepared to get the created employee
    When a GET call is made to get the employee
    Then the status code for this employee is 200
    Then the employee data we get having id "employee.employee_id" must match with globally stored employee ID
    Then the retrieved data at "employee" object matched with the data of created employee
      | emp_firstname  |  emp_lastname  | emp_middle_name |emp_gender|emp_birthday|emp_status|emp_job_title|
      |Daniel          |Guerrero        |Kiran            |Male      |1997-07-13  |fulltime  |SDET         |

    @dynamic
    Scenario: Updating the employee
      Given a request is prepared to update an employee
      When a PUT call is made to update an employee
      Then the status code of updated employee is 200


