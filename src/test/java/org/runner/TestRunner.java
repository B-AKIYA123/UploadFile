package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.slf4j.helpers.Reporter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = 
"src\\test\\resources\\Feature 1\\B_SignIn.feature",

		glue = "org.sample", 	
		monochrome = true, 	
//	tags = "@smoke",				
//tags = "@smoke and @sanity and @regression",
		dryRun = true, 
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
        
public class TestRunner { 	
	
	
	}
