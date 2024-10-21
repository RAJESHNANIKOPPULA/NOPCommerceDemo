package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import org.junit.runner.RunWith;
//import io.cucumber.junit.CucumberOptions;
//import io.cucumber.junit.Cucumber;

@CucumberOptions(features=".//Features//Login.feature",
glue="testDefinitions",
dryRun=false,
monochrome=false,
plugin={"pretty","html:target/test-outputLogin.html"}
)
public class TestRun extends AbstractTestNGCucumberTests{
}
