package StepDefinition;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddEmployee extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
      WebElement pimTab= driver.findElement(By.id("menu_pim_viewPimModule"));
      doClick(pimTab);

    }
    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {
        driver.findElement(By.id("menu_pim_addEmployee")).click();
    }
    @When("user enters first name and middle name and lastname")
    public void user_enters_first_name_and_middle_name_and_lastname() {
WebElement firstNameBox= driver.findElement(By.xpath("//input[@id='firstName']"));
sendText(firstNameBox,ConfigReader.getPropertyValue("firstname"));
driver.findElement(By.xpath("//input[@id='middleName']")).sendKeys(ConfigReader.getPropertyValue("middlename"));
driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(ConfigReader.getPropertyValue("lastname"));
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
WebElement saveBtn=driver.findElement(By.xpath("//input[@id='btnSave']"));
doClick(saveBtn);

    }
}
