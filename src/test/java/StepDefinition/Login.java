package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    WebDriver driver;
    @Given("open the browser and launch HRMS application")
    public void open_the_browser_and_launch_hrms_application() {
       driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
    }
    @When("user enters valid email and valid password")
    public void user_enters_valid_email_and_valid_password() {
      WebElement usernameBox= driver.findElement(By.xpath("//input[@id='txtUsername']"));
      usernameBox.sendKeys("admin");
      WebElement passwordBox=driver.findElement(By.xpath("//input[@id='txtPassword']"));
      passwordBox.sendKeys("Hum@nhrm123");

    }
    @When("click on login button")
    public void click_on_login_button() {
      WebElement loginButton= driver.findElement(By.xpath("//input[@id='btnLogin']"));
      loginButton.click();
    }
    @Then("user is logged in successfully into the application")
    public void user_is_logged_in_successfully() {
     boolean userLoggedIn=  driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).isDisplayed();
     if(userLoggedIn){
         System.out.println("User is logged in successfully");
     }
    }

}
