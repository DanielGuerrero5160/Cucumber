package StepDefinition;

import Pages.LoginPage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class Login extends CommonMethods {

    @Given("open the browser and launch HRMS application")
    public void open_the_browser_and_launch_hrms_application() {
        openBrowserAndLaunchApplication();
    }
    @When("user enters valid email and valid password")
    public void user_enters_valid_email_and_valid_password() {


     // WebElement usernameBox= driver.findElement(By.xpath("//input[@id='txtUsername']"));
      sendText(login.usernameBox,ConfigReader.getPropertyValue("username"));

      //WebElement passwordBox=driver.findElement(By.xpath("//input[@id='txtPassword']"));
      sendText(login.passwordBox,ConfigReader.getPropertyValue("password"));

    }

    @When("click on login button")
    public void click_on_login_button() {
     //WebElement loginButton= driver.findElement(By.xpath("//input[@id='btnLogin']"));
      doClick(login.loginButton);
    }
    @Then("user is logged in successfully into the application")
    public void user_is_logged_in_successfully() {
     boolean userLoggedIn=  driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).isDisplayed();
     if(userLoggedIn){
         System.out.println("User is logged in successfully");
     }
    }
   @Then("Close the browser")
  public void close_the_browser() {
  closeBrowser();
    }
    @When("user enters valid {string} and valid {string}")
    public void user_enters_valid_and_valid(String username, String password) {
        //WebElement usernameBox= driver.findElement(By.xpath("//input[@id='txtUsername']"));
        sendText(login.usernameBox,username);

       // WebElement passwordBox=driver.findElement(By.xpath("//input[@id='txtPassword']"));
        sendText(login.passwordBox,password);
    }
    @When("user enters username and password and verifies login")
    public void user_enters_username_and_password_and_verifies_login(DataTable dataTable) {
       // LoginPage login=new LoginPage();
        List< Map<String,String>> userCredentials=dataTable.asMaps();
        for(Map<String,String> userCreds:userCredentials){

         String username=userCreds.get("username");
           String password=userCreds.get("password");

           sendText(login.usernameBox,username);

            sendText(login.passwordBox,password);

            doClick(login.loginButton);


            doClick(login.welcomeIcon);

            doClick(login.logoutLink);
        }

    }

}
