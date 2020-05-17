package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = {"Features"},
	glue = {"StepDefinitions"}
	//tags= "@tag2"
)

public class CukeExecutor {
	System.out.println("Code from Github");
}
