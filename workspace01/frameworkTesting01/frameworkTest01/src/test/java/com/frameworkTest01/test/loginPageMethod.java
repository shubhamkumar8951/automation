package com.frameworkTest01.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.frameworkTest01.utilities.propertiesClass;
import com.frameworkTest01.utilities.reusableCodes;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class loginPageMethod extends baseClass{
	
	JavascriptExecutor js = ((JavascriptExecutor)driver);
	
	@Given("^The url is provided$")
	public void the_url_is_provided() throws Throwable {
		System.out.println("URL launched and page sucessfully launched");
	}
	
	@Then("^enter id$")
	public void enter_id(DataTable arg1) throws Throwable {
		List<List<String>> table = arg1.raw();
		String emailid = table.get(1).get(0);
		System.out.println(emailid + " emailid");
		Thread.sleep(2000);
		System.out.println("loginpo " + loginpo);
		user.sync( driver,loginpo.emailInputField);
		user.highlightElement(driver,loginpo.emailInputField);
		user.type(loginpo.emailInputField, emailid);
		user.takescreenshot(driver);
	   
	}

	@Then("^provide the password and hit login$")
	public void provide_the_password_and_hit_login() throws Throwable {
		data = propertiesClass.readPropertyFile("input");
		String password =  data.getProperty("password");
		System.out.println(loginpo.password.getAttribute("class"));
		user.sync(driver, loginpo.password);
		user.highlightElement(driver,loginpo.password);
	    user.type(loginpo.password,password);
	    user.click(loginpo.signInButton);
	    user.takescreenshot(driver);
	}

}
