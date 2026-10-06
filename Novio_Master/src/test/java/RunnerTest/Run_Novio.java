package RunnerTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
		features ="src/test/resources/Feature", 
		glue= {"StepDefinitions"},
		tags = "@RegistrationNTC",
//		dryRun = false,
		snippets = SnippetType.CAMELCASE,
		monochrome = true		
			
	)
public class Run_Novio extends AbstractTestNGCucumberTests {
	
	
}

