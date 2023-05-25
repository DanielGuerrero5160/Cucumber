Feature: API workflow for HRMS

  Background:
    Given a JWT is generated

  @api
  Scenario: Create an employee using API call
   Given a request is prepared to create an employee
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201


