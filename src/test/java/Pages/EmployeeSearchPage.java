package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeSearchPage extends CommonMethods {

    public EmployeeSearchPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='empsearch_id']")
   public WebElement idSearchBox;

    @FindBy(xpath = "//input[@id='searchBtn']")
   public WebElement searchBtn;

    @FindBy(xpath ="//select[@id='empsearch_job_title']" )
   public WebElement jobTitleDropDown;
}
