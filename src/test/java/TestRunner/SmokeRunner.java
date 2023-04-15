package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
        glue = "StepDefinition",
        dryRun = false,
       tags ="@empsearch or @smoke ",
plugin = {"pretty","html:target/Cucumber.html","json:target/Cucumber.json", "rerun:target/failed.txt"})//this will generate an html report and save it to target file
//then the /cucumber.html is the name of the report dot file type
public class SmokeRunner {
}
//tags will execute the tagged testcase as mentioned in the runner class

//target folder is mostly used for storing the test case execution reports generated using cucumber