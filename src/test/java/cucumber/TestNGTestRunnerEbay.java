package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Features", glue="Framework.stepDefinitions",
monochrome=true,plugin = {"html:target/cucumber.html"})
public class TestNGTestRunnerEbay extends AbstractTestNGCucumberTests{

}
