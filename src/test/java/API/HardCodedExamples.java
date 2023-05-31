package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.Request;
import org.junit.runners.MethodSorters;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {
  String baseURI=RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
  String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUxNTAxMjgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTE5MzMyOCwidXNlcklkIjoiNTIyMCJ9.aLFs7QoL3-B5GvXOPNmw2__nkdpqTT-qp4R-n1w93Io";

    static String employeeID;
@Test
    public void acreateEmployee(){
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

    //we are capturing employeeID from the response
   employeeID=response.jsonPath().getString("Employee.employee_id");
    System.out.println(employeeID);

//verifying the firstname in the response body----Hamcrest matchers
    response.then().assertThat().body("Employee.emp_firstname", equalTo("Daniel"));
    System.out.println("My test case has passed");
    //verifying lastname
    response.then().assertThat().body("Employee.emp_lastname",equalTo("Guerrero"));
    //verify the response headers
    response.then().assertThat().header("Content-Type",equalTo("application/json"));
    System.out.println("My test case has passed");

    }
    @Test
    public void bgetCreatedEmployee(){
    RequestSpecification preparedRequest=given().header("Content-Type","application/json").
            header("Authorization",token).queryParam("employee_id",employeeID);

    Response response=preparedRequest.when().get("/getOneEmployee.php");
    response.prettyPrint();
    //verifying status code
    response.then().assertThat().statusCode(200);

      String tempEmpID=response.jsonPath().getString("employee.employee_id");

        Assert.assertEquals(employeeID,tempEmpID);
    }
@Test
    public void cupdateEmployee(){
    RequestSpecification preparedRequest=given().header("Content-Type","application/json").
            header("Authorization",token).body("{\n" +
                    "  \"employee_id\": \""+employeeID+"\",\n" +
                    "  \"emp_firstname\": \"Danielle\",\n" +
                    "  \"emp_lastname\": \"Gansamer\",\n" +
                    "  \"emp_middle_name\": \"ms\",\n" +
                    "  \"emp_gender\": \"F\",\n" +
                    "  \"emp_birthday\": \"1997-05-20\",\n" +
                    "  \"emp_status\": \"Part-Time\",\n" +
                    "  \"emp_job_title\": \"Secretary\"\n" +
                    "}");

    //hitting the endpoint
        Response response=preparedRequest.when().put("/updateEmployee.php");
        //verifying status code
        response.then().assertThat().statusCode(200);
//verifying message
        response.then().assertThat().body("Message",equalTo("Employee record Updated"));

    }

    @Test
    public void dgetUpdatedEmployee(){
        RequestSpecification preparedRequest=given().header("Content-Type","application/json").
                header("Authorization",token).queryParam("employee_id",employeeID);

//hitting endpoint
        Response response=preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        //verifying status code
        response.then().assertThat().statusCode(200);

       // if you want to verify the body of the response, we can do that using hamcrest matchers
        response.then().assertThat().header("Content-Type",equalTo("application/json"));

        response.then().assertThat().body("employee.emp_firstname",equalTo("Danielle"));


    }
    @Test
    public void getEmployeeStatus(){
        RequestSpecification preparedRequest=given().header("Content-Type","Application/json").header("Authorization",token);

        Response response=preparedRequest.when().get("/employeementStatus.php");
        response.prettyPrint();

        JsonPath jsonPath=response.jsonPath();

        List<Map<String, Object>> jsonArray = jsonPath.getList("'Employeement Status'");

        for(Map<String, Object> jsonObject:jsonArray){
            String idValue=jsonObject.get("id").toString();
            Assert.assertNotNull(idValue);
            System.out.println("ID: "+idValue);
        }


    }
    @Test
    public void getJobTitles(){
    RequestSpecification preparedRequest=given().header("Content-Type","application/json").header("Authorization",token);

    Response response=preparedRequest.when().get("/jobTitle.php");

    response.prettyPrint();

    JsonPath jsonPath=response.jsonPath();

    List<Map<String, Object>> jobsMapList=jsonPath.getList("'Jobs'");

    for(Map<String,Object> jobMap:jobsMapList){
        String job=jobMap.get("job").toString();
        System.out.println(job);
        Assert.assertNotNull(job);
    }


    }



}
