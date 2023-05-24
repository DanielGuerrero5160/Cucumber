package StepDefinition;

import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.DBUtility;
import Utils.GlobalVariables;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddEmployee extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
      //WebElement pimTab= driver.findElement(By.id("menu_pim_viewPimModule"));
      doClick(addEmployeePage.pimTab);

    }
    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {

        //driver.findElement(By.id("menu_pim_addEmployee")).click();
        doClick(addEmployeePage.addEmpBtn);
    }
    @When("user enters first name and middle name and lastname")
    public void user_enters_first_name_and_middle_name_and_lastname() {

//WebElement firstNameBox= driver.findElement(By.xpath("//input[@id='firstName']"));
sendText(addEmployeePage.firstNameBox,ConfigReader.getPropertyValue("firstname"));

// driver.findElement(By.xpath("//input[@id='middleName']")).sendKeys(ConfigReader.getPropertyValue("middlename"));
sendText(addEmployeePage.middleNameTextBox,ConfigReader.getPropertyValue("middlename"));
        //driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(ConfigReader.getPropertyValue("lastname"));
        sendText(addEmployeePage.lastNameTextBox,ConfigReader.getPropertyValue("lastname"));
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
//WebElement saveBtn=driver.findElement(By.xpath("//input[@id='btnSave']"));
        Assert.assertTrue(addEmployeePage.saveBtn.isEnabled());
doClick(addEmployeePage.saveBtn);

    }
    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String firstName, String middleName, String lastName) {
       sendText(addEmployeePage.firstNameBox,firstName);
       sendText(addEmployeePage.middleNameTextBox,middleName);
       sendText(addEmployeePage.lastNameTextBox, lastName);
    }
    @When("user captures the employee id")
    public void user_captures_the_employee_id() {
        GlobalVariables.emp_id = addEmployeePage.empIdLocator.getAttribute("value");
        System.out.println("The employee id is: " + GlobalVariables.emp_id);
    }

    @When("query the information in backend")
    public void query_the_information_in_backend() {
        String query = "select * from hs_hr_employees where employee_id='"
                + GlobalVariables.emp_id+"'";
        //GlobalVariables.emp_id
        //to store the table coming from db, we used global variable here
        //in this variable we got all the keys and values for the employee we searched
        GlobalVariables.tabledata = DBUtility.getListOfMapsFromRset(query);
        System.out.println(GlobalVariables.tabledata);
    }

    @Then("verify the results from frontend and backend")
    public void verify_the_results_from_frontend_and_backend() {
        String firstNameFromDB = GlobalVariables.tabledata.get(0).get("emp_firstname");
        System.out.println(firstNameFromDB);
        String lastNamefromDB = GlobalVariables.tabledata.get(0).get("emp_lastname");
        System.out.println(lastNamefromDB);

        //adding assertions
        Assert.assertEquals(firstNameFromDB, "nesha");
        Assert.assertEquals(lastNamefromDB, "standart");
        System.out.println("My assertion has passed my test case");
    }

}
