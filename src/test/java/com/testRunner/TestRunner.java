package com.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src\\test\\resources\\com.Features"},
		glue = {"com.StepDefinition","com.hooksClass"},
		//tags="@reject",
		plugin = {"pretty","html:target/cucumber-report.html"})

public class TestRunner extends AbstractTestNGCucumberTests {

}

