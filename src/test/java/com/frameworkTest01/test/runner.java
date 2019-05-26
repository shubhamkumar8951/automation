package com.frameworkTest01.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



	
	@RunWith(Cucumber.class)
	@CucumberOptions(features = "src/test/resources/operationListBox.feature",
	glue= {"com/frameworkTest01/test"},
	plugin = {"pretty","html:target/cucumber-html-report","json:target/cucumber.json"})
	
	public class runner{
		
	}
	


