package com.facebook.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

//import org.testng.internal.PropertiesFile;

import com.facebook.pageObject.login;
import com.facebook.utilities.PropertiesFile;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Setup {
	public static WebDriver driver;
	public static FileOutputStream fos = null;
	File file;
	public static String Browser = null;
	public static Properties data = null;
	public static String scenarioName = null;
	public static Actions action; 
	public static Scenario scenario;
	//public static PropertiesFile pro; 
	public static boolean BrowserLaunched = false;
	
	public static login login_Obj = null;
	
	
	@Before
	public  boolean initializingBrowser(Scenario currentScenario)throws Exception{
		scenario = currentScenario;
		scenarioName = currentScenario.getName();
		 data = PropertiesFile.readPropertiesFile("input");
		 System.out.println("browserchoice selected");
		 String browserChoice = data.getProperty("Browser");
		 if(browserChoice.equalsIgnoreCase("Chrome")){
			 System.out.println("chrome driver path found");
			 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/exe/chromedriver.exe");
			 
			 ChromeOptions options = new ChromeOptions();
		
			 options.addArguments("--disable extension");
			 
			 //options.setExperimentalOption("useAutomationExtension", false);
			 options.addArguments("--start-maximized");
			 options.addArguments("disable-infobars");
			 options.addArguments("no-sandbox");
			 
				
			 DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			 capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			  capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			
			  //capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
			 
			  	driver = new ChromeDriver(capabilities);
			  	driver.get(data.getProperty("url"));
			 //driver.manage().deleteAllCookies();
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 //driver.manage().window().fullscreen();
			 action = new Actions(driver);
			 Capabilities cap1 = (((RemoteWebDriver)driver).getCapabilities());
			 Browser = cap1.getBrowserName().toLowerCase();
			 BrowserLaunched = true;
			 //driver.navigate().to(url);
			 //driver.get(data.getProperty("url"));
		 }
		 else {
			 try{
				 throw new Exception("Custom Exception");
					 
				 }
			 catch(Exception e){
				 scenario.write("Chrome not working");
			 }
		 }
			 
		 login_Obj = PageFactory.initElements(driver,login.class);
		 return BrowserLaunched;
		 
	}
	
	@After
	public static void aftersetup(Scenario result)throws Exception{
		if(result.isFailed()){
			
		}
//		driver.close();
		//driver.quit();
	}
	
	




}
