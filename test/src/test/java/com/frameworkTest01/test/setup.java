package com.frameworkTest01.test;

import java.io.IOException;

import com.frameworkTest01.utilities.propertiesClass;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class setup extends baseClass{

	
	@Before
	public static void initilizingBrowser() throws IOException{
		data = propertiesClass.readPropertyFile("input");
		System.out.println("into before");
		String URL = data.getProperty("url");
		System.out.println(URL + " is the working URL");
		browserSelected("chrome");
		pagefactoryImplementations();
		System.out.println("Setup completed");
	}
	
	@After
	public static void afterSetup() throws IOException{
		
		driver.close();
		driver.quit();
		Runtime.getRuntime().exec("taskkill /f /im /chrome.exe");
	}
	

}
