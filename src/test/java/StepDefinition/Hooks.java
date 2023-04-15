package StepDefinition;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {

 @Before
public void preConditions(){
    openBrowserAndLaunchApplication();
}

//scenario class holds the complete information of your test execution in Cucumber Framework
@After
public void postConditions(Scenario scenario){
byte[] pic;
if(scenario.isFailed()){
    pic=takeScreenShot("failed/"+scenario.getName());
}else{
    pic=takeScreenShot("passed/"+scenario.getName());
}
//Attach the screenshot to our reports
    scenario.attach(pic,"image/png", scenario.getName());


    closeBrowser();

}
}
