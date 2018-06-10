package com.frameworkTest01.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.frameworkTest01.test.baseClass;

public class reusableCodes extends baseClass{
	
	
	public void click(WebElement e){
		e.click();
	
	}
	
	public void sync(WebDriver driver,WebElement e){
		WebDriverWait wait = new WebDriverWait(driver,30);
		e = wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	public void type(WebElement e, String arg1){
		e.click();
		e.clear();
		e.sendKeys(arg1);
	}
	
	public void takescreenshot(WebDriver driver) throws IOException{
		TakesScreenshot screenShot = ((TakesScreenshot)driver);
		File srcFile = screenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir")+ "/screenshots/screenshots.png");
		FileUtils.copyFile(srcFile, destFile); 
	}
	
	public void highlightElement(WebDriver driver,WebElement e) throws InterruptedException{
		JavascriptExecutor js1 = ((JavascriptExecutor)driver);
		js1.executeScript("arguments[0].style.border='4px groove red'", e);
		Thread.sleep(1000);  
        js1.executeScript("arguments[0].style.border=''", e);  
	}

}
