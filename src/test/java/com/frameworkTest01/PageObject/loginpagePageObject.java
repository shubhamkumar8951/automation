package com.frameworkTest01.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.frameworkTest01.test.baseClass;


public class loginpagePageObject extends baseClass{

	@FindBy(how = How.XPATH, using = "//input[@id='login-email']")
	public WebElement emailInputField;

	@FindBy(how = How.XPATH, using = "//input[@id='login-password']")
	public WebElement password;

	@FindBy(how = How.XPATH, using = "//input[@value='Sign in']")
	public WebElement signInButton;
	
	@FindBy(how = How.XPATH, using = "//*")
	public List<WebElement> allElements;
	
	public List<WebElement> uiElementsOverall_inputText(){
		List<WebElement> el = driver.findElements(By.xpath("//*//input[@type='text']"));
		return el;
	}
	
	public List<WebElement> notification(){
		List<WebElement> el = driver.findElements(By.xpath("//button[text()='No Thanks']"));
		return el;
	}
	
	public List<WebElement> messengerIcon(){
		List<WebElement> el = driver.findElements(By.xpath("//a[contains(@class,'button-activator')]//div"));
		return el;
	}
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'bg-activator')]//*[local-name() = 'svg'][contains(@class,'svg-close')]")
	public WebElement closeIcon;
	
	public WebElement Icons(String s1, WebDriver driver){
		WebElement e1 = driver.findElement(By.xpath("//div[@class='circleicons']/following-sibling::h4[text()='"+s1+"']"));
		return e1;
	}
}
