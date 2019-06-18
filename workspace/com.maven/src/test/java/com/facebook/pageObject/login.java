package com.facebook.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class login {
	
	 @FindBy(how = How.XPATH,using = "//input[@id='login-email']")
	public WebElement email;
	 
	 @FindBy(how = How.XPATH,using = "//input[@id='login-password']")
		public WebElement password;
	 
	 @FindBy(how = How.XPATH,using = "//input[@value='Sign in']")
		public WebElement signInButton;
	 
	 
	 
	 

}
