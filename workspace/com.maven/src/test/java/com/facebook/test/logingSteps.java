package com.facebook.test;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.facebook.pageObject.login;
import com.facebook.utilities.PropertiesFile;
import com.facebook.utilities.action;
import com.sun.jna.platform.win32.SetupApi;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class logingSteps {
	
	public static Setup setup = null;
	 public login login_Obj = setup.login_Obj;
	WebDriver driver = setup.driver;
	public static Scenario scenario;
	public static action user = new action();
	public static Properties data = null;
	//setup= setup.driver;
    
	
	
	@Given("^The url is provided$")
	public void the_url_is_provided() throws Throwable {
	   //login_Obj.loginID.click();
		//Scenario sc = setup.scenario;
		System.out.println("chrome launched");
	}
	
	@Then("^enter id$")
	public void enter_id(DataTable arg1) throws Throwable {
		List<List<String>> table = arg1.raw();
		//user.sync(driver, login_Obj.email);
		//user.typeFromDataTable(driver, login_Obj.email, table);
		Thread.sleep(2000);
	   driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys(table.get(1).get(0));
	}

	@Then("^provide the password and hit login$")
	public void provide_the_password_and_hit_login() throws Throwable {
		data = PropertiesFile.readPropertiesFile("input");
		String password =  data.getProperty("password");
		System.out.println(password);
		System.out.println(login_Obj.password.getAttribute("class"));
		
	    user.type(driver, login_Obj.password,password);
	    user.click(login_Obj.signInButton);
	    try{
	    	
	    	
	    }
	   
	    catch (NullPointerException n){
	    	
	    }
	}
	    
	

}
