package com.frameworkTest01.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



	
	@RunWith(Cucumber.class)
	@CucumberOptions(features = "src/test/resources",
	glue="com/frameworkTest01/test")
	
	public class runner{
		
	}
	


