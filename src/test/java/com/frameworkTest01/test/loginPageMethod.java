package com.frameworkTest01.test;
import com.frameworkTest01.utilities.propertiesClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
public class loginPageMethod extends baseClass{
	
	
	
	@Given("^The url is provided$")
	public void the_url_is_provided() throws Throwable {
		user.pageReadyState();
		String pageUrl = driver.getCurrentUrl();
		System.out.println("the obtained URL is "+ pageUrl);
		String providedURL = propertiesClass.readPropertyFile("input").getProperty("url");
		System.out.println("the provided URL is "+ providedURL);
		System.out.println("URL launched and page sucessfully launched");
		if(loginpo.notification().size()>0){
			user.click(loginpo.notification().get(0));
		}
	}
	
	@Then("^select table \"([^\"]*)\"$")
	public void select_table(String arg1) throws Throwable {
		user.sync(driver,pagination.dropDown_Table );
		user.click(pagination.dropDown_Table);
		user.sync(driver,pagination.dropdown_FieldName(arg1, driver) );
		user.click(pagination.dropdown_FieldName(arg1, driver));
	}
	
	@Then("^select progress bar \"([^\"]*)\"$")
	public void select_progress_bar(String arg1) throws Throwable {
		user.sync(driver,pagination.dropDown_ProgressBar );
		user.click(pagination.dropDown_ProgressBar);
		user.sync(driver,pagination.dropdown_FieldName(arg1, driver) );
		user.click(pagination.dropdown_FieldName(arg1, driver));
	}
	
	@Then("^select bootstrap \"([^\"]*)\"$")
	public void select_bootstrap(String arg1) throws Throwable {
		user.sync(driver,pagination.dropDown_AlertModel );
		user.click(pagination.dropDown_AlertModel);
		user.sync(driver,pagination.dropdown_FieldName(arg1, driver) );
		user.click(pagination.dropdown_FieldName(arg1, driver));
	}
	
	@Then("^select listbox \"([^\"]*)\"$")
	public void select_listbox(String arg1) throws Throwable {
		user.sync(driver,pagination.dropDown_ListBox );
		user.click(pagination.dropDown_ListBox);
		user.sync(driver,pagination.dropdown_FieldName(arg1, driver) );
		user.click(pagination.dropdown_FieldName(arg1, driver));
	}

	@Then("^select others \"([^\"]*)\"$")
	public void select_others(String arg1) throws Throwable {
		user.sync(driver,pagination.dropdown_Others );
		user.click(pagination.dropdown_Others);
		user.sync(driver,pagination.dropdown_FieldName(arg1, driver) );
		user.click(pagination.dropdown_FieldName(arg1, driver));
	}
	
	
}
