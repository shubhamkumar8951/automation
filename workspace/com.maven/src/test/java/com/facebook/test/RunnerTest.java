package com.facebook.test;

import org.junit.runner.RunWith;
import javax.annotation.Resource; 

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/loginpage.feature"},
		plugin = {"html:target/cucumber-html-report","json:target/cucumber.json"},
				format = {"pretty", "html:target/cucumber-htmlreport","json:target/cucumber-report.json"},
		glue={
				"com/facebook/test"
		},
			strict=true,dryRun=true,monochrome=true,snippets=SnippetType.CAMELCASE)
				
		
		

public class RunnerTest {

}
