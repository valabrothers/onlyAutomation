package testRunner;

import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;


@RunWith(Cucumber.class)
@Category(testRunner1Test.class)
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

public class testRunner1Test {



	
	
}
