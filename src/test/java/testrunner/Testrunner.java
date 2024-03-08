package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/Features"},
		glue="stepdefinition",
		plugin= {"pretty","html:report/htmlreport.html"},
		dryRun=false, 
		monochrome =true,
		publish=true
		
		)
public class Testrunner {

}
