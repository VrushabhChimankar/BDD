package RunnerTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (
		
		features =  ".//Features/LoginFt.feature",
		tags = "@Sanity",
		//tags = "@Sanity or regression", // doni pn execute hotil
		// ani jeva sanity and regression lihla asel teva sanity ani regression associated asel tevach hoil\
		// for ex : scenario chya varti @sanity @regression
		//features = {".//Features/AddCustomer.feature",".//Features/LoginFeature.feature"},
		//For executing all features file in Features folder
		//features = ".//Features/",
		glue = "Stepdefinition", dryRun = false , monochrome  = true,
		//plugin = {"pretty", "html:target/Cucumber-Report/Report01.html"}
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		//"html:target/Cucumber-Report/Report1.html" This statement is used to create html report
		
		)
public class Run {
//This class will be empty
}
