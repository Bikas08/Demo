package automation;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

@CucumberOptions(
  features = "src/test/resources/features",
  glue = "automation.steps",
  plugin = {"pretty", "json:target/cucumber.json", "html:target/cucumber-reports.html"},
  monochrome = true
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
	
}