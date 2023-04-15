package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {
    @FindBy(xpath = "//input[@id='txtUsername']")
   public WebElement usernameBox;
@FindBy(xpath = "//input[@id='txtPassword']")
   public WebElement passwordBox;
@FindBy(xpath = "//input[@id='btnLogin']")
   public WebElement loginButton;

@FindBy(id = "welcome")
public WebElement welcomeIcon;
@FindBy(xpath = "//a[text()='Logout']")
   public WebElement logoutLink;

public LoginPage(){
    PageFactory.initElements(driver,this);
}

    //page factory model
}

