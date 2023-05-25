package APIStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class APIWorkflowSteps {

    @Given("a request is prepared to create an employee")
    public void a_request_is_prepared_to_create_an_employee() {
        RequestSpecification preparedRequest=given().
                header("Content-Type","application/json").
                header("Authorization",GenerateTokenSteps.token).body("{\n" +
                        "    \"emp_firstname\": \"Daniel\",\n" +
                        "    \"emp_lastname\": \"Guerrero\",\n" +
                        "    \"emp_middle_name\": \"Kiran\",\n" +
                        "    \"emp_gender\": \"M\",\n" +
                        "    \"emp_birthday\": \"1997-07-13\",\n" +
                        "    \"emp_status\": \"FullTime\",\n" +
                        "    \"emp_job_title\": \"SDET\"\n" +
                        "}");
    }
    @When("a POST call is made to create an employee")
    public void a_post_call_is_made_to_create_an_employee() {

    }
    @Then("the status code for creating an employee is {int}")
    public void the_status_code_for_creating_an_employee_is(Integer int1) {

    }

}
