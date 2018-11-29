package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(glue="stepDef",
				features= {
		"src/test/resources/Feature/"		
		},
plugin= {
		"com.cucumber.listener.ExtentCucumberFormatter:output/report.html",
		"pretty",
		"html:result/html"
}
)

public class testRunnerTest {



	
	
}
