package Utils;

import org.json.JSONObject;

import static APIStepDefinitions.APIWorkflowSteps.employee_id;

public class APIPayloadConstants {
//we will pass the body in multiple formats
    //for this we have created this other constants class

    public static String createEmployeePayload(){
       String createEmployeePayload="{\n" +
               "    \"emp_firstname\": \"Daniel\",\n" +
               "    \"emp_lastname\": \"Guerrero\",\n" +
               "    \"emp_middle_name\": \"Kiran\",\n" +
               "    \"emp_gender\": \"M\",\n" +
               "    \"emp_birthday\": \"1997-07-13\",\n" +
               "    \"emp_status\": \"FullTime\",\n" +
               "    \"emp_job_title\": \"SDET\"\n" +
               "}";

       return createEmployeePayload;
    }
    //if we have problem with body
    public static String createEmployeePayloadJson(){
        JSONObject obj=new JSONObject();
        obj.put("emp_firstname","Daniel");
        obj.put("emp_lastname","Guerrero");
        obj.put("emp_middle_name","Kiran");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","1997-07-13");
        obj.put("emp_status","FullTime");
        obj.put("emp_job_title","SDET");
        return obj.toString();
    }

    public static String createEmployeePayloadJsonDynamic(String emp_firstname, String emp_lastname,
                                                          String emp_middle_name,
                                                          String emp_gender, String emp_birthday, String emp_status,
                                                          String emp_job_title){
        JSONObject obj=new JSONObject();
        obj.put("emp_firstname",emp_firstname);
        obj.put("emp_lastname",emp_lastname);
        obj.put("emp_middle_name",emp_middle_name);
        obj.put("emp_gender",emp_gender);
        obj.put("emp_birthday",emp_birthday);
        obj.put("emp_status",emp_status);
        obj.put("emp_job_title",emp_job_title);
        return obj.toString();
    }

    public static String UpdateEmployeePayloadJson(){
        JSONObject obj=new JSONObject();
        obj.put("employee_id",employee_id);
        obj.put("emp_firstname","Danielle");
        obj.put("emp_lastname","Gansamer");
        obj.put("emp_middle_name","Sally");
        obj.put("emp_gender","F");
        obj.put("emp_birthday","1989-04-13");
        obj.put("emp_status","PartTime");
        obj.put("emp_job_title","Secretary");
        return obj.toString();
    }

}
