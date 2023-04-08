package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
        glue = "StepDefinition",
        dryRun = false,
       tags ="@smoke2",
plugin = {"pretty"})
public class SmokeRunner {
}
//tags will execute the tagged testcase as mentioned in the runner class