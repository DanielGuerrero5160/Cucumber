package Utils;

import StepDefinition.PageInitializer;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class CommonMethods extends PageInitializer {
    public static WebDriver driver;
    public static void openBrowserAndLaunchApplication(){
ConfigReader.readProperties();
        String browserType=ConfigReader.getPropertyValue("browserType");
        switch(browserType){
            case "Chrome":
                ChromeOptions ops=new ChromeOptions();
                ops.addArguments("--no-sandbox");
                ops.addArguments("--remote-allow-origins=*");
                if(ConfigReader.getPropertyValue("Headless").equals("true")) {
                    ops.addArguments("--headless=new");
                }
                driver=new ChromeDriver(ops);
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
//this will initialize all the pages we have in our page
        //page initializer class along with the launch of the application
        initializePageObjects();
        // to configure the log File and pattern it has
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("This is the beginning of the test case");
        Log.info("The test case is executing right now");
        Log.warning("The test case might have some trivial issues");
    }
    public static void closeBrowser(){
        Log.info("This test case is about to get completed");
        Log.endTestCase("This test case is finished");
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

    //this casts the webdriver instance driver to takeScreenshot interface
    public static byte[] takeScreenShot(String imageName){
        TakesScreenshot ts=(TakesScreenshot)driver;
        //this captures the screenshot and stores it as an array of Bytes
       byte[] picBytes= ts.getScreenshotAs(OutputType.BYTES);//screenshots are stored in array of bytes
        //this captures the screenshot and stores them as a file in the sourceFile variable
       File sourcePath=ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourcePath,new File(Constants.SCREENSHOT_FILEPATH+imageName+getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
return picBytes;

    }
    public static String getTimeStamp(String pattern){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
       return sdf.format(date);
    }
}
