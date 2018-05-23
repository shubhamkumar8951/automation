package com.facebook.utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class action {
	
	public void sync(WebDriver driver,WebElement element) throws Exception{
	try{
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOf(element));
		}
	catch(Exception e){
		System.out.println("Element not visible");
		
		throw e;
	}
	}
	
	public void click(WebElement element) throws Exception{
		try{
			element.click();
		}catch(Exception e){
			System.out.println("element not clickable");
			throw e;
		}
	}
	public void type(WebDriver driver,WebElement element, String s) throws Exception{
		try{
			element.click();
			element.clear();
			element.sendKeys(s);
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println("not able to type");
			throw e;
		}
	}
	
	public void typeFromDataTable(WebDriver driver,WebElement element,String table) throws Exception{
		try{
			element.clear();
			element.sendKeys(table);
		}catch(Exception e){
			System.out.println("not able to type");
			throw e;
		}
	}
}
