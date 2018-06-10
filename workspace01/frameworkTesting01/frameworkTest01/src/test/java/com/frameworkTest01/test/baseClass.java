package com.frameworkTest01.test;


import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.frameworkTest01.PageObject.loginpagePageObject;
import com.frameworkTest01.utilities.propertiesClass;
import com.frameworkTest01.utilities.reusableCodes;

public class baseClass {

	public static WebDriver driver = null;
	public static Properties data = new Properties() ;
	//Actions action = new Actions(driver);
	public static reusableCodes user = new reusableCodes();
	public static loginpagePageObject loginpo;
	//public JavascriptExecutor js = (JavascriptExecutor)driver;
	
	protected static WebDriver getDriverInstance(DesiredCapabilities c){
		   driver=new ChromeDriver();
		   return driver;
		}

	public static void browserSelected(String browserName) throws IOException {
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/exe/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable extension");
			options.setExperimentalOption("useAutomationExtension", false);
			options.addArguments("--start-maximized");
			options.addArguments("disable-infobars");
			options.addArguments("no-sandbox");

			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			//driver = new ChromeDriver(capabilities);
			driver = getDriverInstance(capabilities);
			driver.get(propertiesClass.readPropertyFile("input").getProperty("url"));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Capabilities cap1 = (((RemoteWebDriver) driver).getCapabilities());
			driver.manage().window().maximize();
			/*Browser = cap1.getBrowserName().toLowerCase();
			BrowserLaunched = true;*/
			
		}
	}
	
	public static void pagefactoryImplementations(){
	 loginpo = PageFactory.initElements(driver, loginpagePageObject.class);
	}

}
