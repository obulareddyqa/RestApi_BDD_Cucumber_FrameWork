package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",plugin={"pretty","html:target/cucumber-reports"},glue= {"stepDefination"},monochrome = true)
public class TestRunner {
	
	//,tags="@DeletePlace"
	//json:target/jsonReport/cucumber_report.json

}
