package StepDefinition;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmployeeSearch extends CommonMethods {

    @When("user enters valid employee ID")
    public void user_enters_valid_employee_id() {
        //WebElement idSearchBox=driver.findElement(By.xpath("//input[@id='empsearch_id']"));
        sendText(employeeSearchPage.idSearchBox, ConfigReader.getPropertyValue("empid"));

    }
    @When("clicks on search button")
    public void clicks_on_search_button() {
//WebElement searchBtn= driver.findElement(By.xpath("//input[@id='searchBtn']"));
doClick(employeeSearchPage.searchBtn);
    }
    @When("user sees employee information displayed")
    public void user_sees_employee_information_displayed() {
        System.out.println("Employee is displayed");
    }
    @When("user selects job title")
    public void user_selects_job_title() {
        //WebElement jobTitleDropDown=driver.findElement(By.xpath("//select[@id='empsearch_job_title']"));
       selectByOption(employeeSearchPage.jobTitleDropDown,ConfigReader.getPropertyValue("jobTitle"));

       //WebElement empStatus=driver.findElement(By.xpath("//select[@id='empsearch_employee_status']"));
      // selectByOption(empStatus,"Active");
    }

}
