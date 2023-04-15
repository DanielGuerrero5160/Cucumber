package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/failed.txt",
        glue = "StepDefinition",
        //dryRun = false,
        //tags ="@empsearch or @smoke",
        plugin = {"pretty"})
public class FailedRunner {
}
