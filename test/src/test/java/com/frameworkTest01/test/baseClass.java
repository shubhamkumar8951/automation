package com.frameworkTest01.test;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.frameworkTest01.PageObject.PaginationPageObject;
import com.frameworkTest01.PageObject.loginpagePageObject;
import com.frameworkTest01.utilities.propertiesClass;
import com.frameworkTest01.utilities.reusableCodes;

public class baseClass {

	public static WebDriver driver = null;
	public static Properties data = new Properties();
	public static reusableCodes user = new reusableCodes();
	public static propertiesClass propertiesclass = new propertiesClass();
	public static loginpagePageObject loginpo;
	public static PaginationPageObject pagination;
	private static JavascriptExecutor js;
	protected static Actions action;
	public static WebDriverWait wait;
	
	
	
	protected static WebDriver getDriverInstance(DesiredCapabilities c) {
		driver = new ChromeDriver();
		setJs(((JavascriptExecutor) driver));
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 30);
		return driver;
	}

	public static void browserSelected(String browserName) throws IOException {
		if (browserName.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/exe/chromedriver.exe");
			options.addArguments("--disable extension");
			options.setExperimentalOption("useAutomationExtension", false);
			options.addArguments("--start-maximized");
			options.addArguments("disable-infobars");
			options.addArguments("no-sandbox");
			options.addArguments("--disable-notifications");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			driver = getDriverInstance(capabilities);
			driver.get(propertiesClass.readPropertyFile("input").getProperty("url"));
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
	}

	public static void pagefactoryImplementations() {
		loginpo = PageFactory.initElements(driver, loginpagePageObject.class);
		pagination = PageFactory.initElements(driver, PaginationPageObject.class);
	}

	public static JavascriptExecutor getJs() {
		return js;
	}

	public static void setJs(JavascriptExecutor js) {
		baseClass.js = js;
	}

}
