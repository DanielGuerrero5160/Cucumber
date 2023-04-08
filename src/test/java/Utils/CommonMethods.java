package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class CommonMethods {
    public static WebDriver driver;
    public static void openBrowserAndLaunchApplication(){
ConfigReader.readProperties();
        String browserType=ConfigReader.getPropertyValue("browserType");
        switch(browserType){
            case "Chrome":
                driver=new ChromeDriver();
                break;
            case "Firefox":
                driver=new FirefoxDriver();
                break;
            case "IE":
                driver=new InternetExplorerDriver();
                break;
            default:
                driver=new EdgeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("URL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Constants.WAIT_TIME));

    }
    public static void closeBrowser(){
        driver.close();
    }


    public static void doClick(WebElement element){
        element.click();
    }

    public static void sendText(WebElement element,String text){
        element.clear();
        element.sendKeys(text);
    }

    public static Select clickOnDropdown(WebElement element){
        Select select=new Select(element);
        return select;
    }
    public static void selectByValue(WebElement element,String value){
        clickOnDropdown(element).selectByValue(value);
    }

    public static void selectByVisibleText(WebElement element,String text){
        clickOnDropdown(element).selectByVisibleText(text);
    }
    public static void selectByIndex(WebElement element,int index){
        clickOnDropdown(element).selectByIndex(index);
    }

    public static void selectByOption(WebElement element,String text){
       List<WebElement> options =clickOnDropdown(element).getOptions();
       for(WebElement option:options){
          String ddlOptionText=option.getText();
          if(ddlOptionText.equalsIgnoreCase(text)){
             option.click();
          }
       }
    }
}
