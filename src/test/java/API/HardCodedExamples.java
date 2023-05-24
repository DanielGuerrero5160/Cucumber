package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class HardCodedExamples {
  String baseURI=RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
    String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODQ4ODc4NTIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NDkzMTA1MiwidXNlcklkIjoiNTIyMCJ9.CkF1e9Az8USNtjZAC2rsNFMzOLMkjzXvBaH-UOPVHkk";

@Test
    public void createEmployee(){
        //prepare the request
        RequestSpecification preparedRequest=given().
                header("Content-Type","application/json").
                header("Authorization",token).body("{\n" +
                        "    \"emp_firstname\": \"Daniel\",\n" +
                        "    \"emp_lastname\": \"Guerrero\",\n" +
                        "    \"emp_middle_name\": \"Kiran\",\n" +
                        "    \"emp_gender\": \"M\",\n" +
                        "    \"emp_birthday\": \"1997-07-13\",\n" +
                        "    \"emp_status\": \"FullTime\",\n" +
                        "    \"emp_job_title\": \"SDET\"\n" +
                        "}");

        //hitting the endpoint
Response response=preparedRequest.when().post("/createEmployee.php");  //we put the endpoint in post
        //send the request
   response.then().assertThat().statusCode(201);   //then is the results/expected output
    response.prettyPrint(); //will print the output in the console


//verifying the firstname in the response body
    response.then().assertThat().body("Employee.emp_firstname", equalTo("Daniel"));
    System.out.println("My test case has passed");



    }
}
