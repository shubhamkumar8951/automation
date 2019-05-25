package com.frameworkTest01.utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.frameworkTest01.test.baseClass;

public class reusableCodes extends baseClass {

	public void click(WebElement e) {
		sync(driver, e);
		e.click();

	}

	public void sync(WebDriver driver, WebElement e) {
		e = wait.until(ExpectedConditions.visibilityOf(e));
	}

	public void type(WebElement e, String arg1) {
		action.moveToElement(e);
		click(e);
		e.clear();
		e.sendKeys(arg1);
	}

	public void typeWithoutClearing(WebElement e, String arg1) {
		action.moveToElement(e);
		click(e);
		e.sendKeys(arg1);
	}

	public String gettext(WebElement e) {
		click(e);
		String s = e.getText();
		return s;
	}

	public String getAttribute(WebElement e, String attributeName) {
		click(e);
		String s = e.getAttribute(attributeName);
		return s;
	}

	public void hover(WebDriver driver, WebElement e) {
		action.moveToElement(e).build().perform();
	}

	public void scrollToView(WebDriver driver, WebElement e) throws InterruptedException {
		Coordinates cor = ((Locatable) e).getCoordinates();
		System.out.println(cor);
		cor.inViewPort();
		Thread.sleep(1000);
	}

	public void takescreenshot(WebDriver driver) throws IOException {
		TakesScreenshot screenShot = ((TakesScreenshot) driver);
		File srcFile = screenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir") + "/screenshots/screenshots.png");
		FileUtils.copyFile(srcFile, destFile);
	}

	public void highlightElement(WebDriver driver, WebElement e) throws InterruptedException {
		JavascriptExecutor js1 = ((JavascriptExecutor) driver);
		js1.executeScript("arguments[0].style.border='4px groove red'", e);
		Thread.sleep(1000);
		js1.executeScript("arguments[0].style.border=''", e);
	}

	public void pageReadyState() {
		if (getJs().executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page Is loaded.");
			return;
		}
		for (int i = 0; i < 25; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			if (getJs().executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}

	public void ifAlertPresent() throws InterruptedException {
		int i = 0;
		while (i++ < 5) {
			try {
				Alert alert = driver.switchTo().alert();
				alert.dismiss();
				System.out.println("Alert dismissed");
				break;
			} catch (NoAlertPresentException e) {
				Thread.sleep(1000);
				continue;
			}
		}
	}

	public int webelementSize(String s1, String locatortype) {
		List<WebElement> el = null;
		if (locatortype.equals("xpath")) {
			el = driver.findElements(By.xpath(s1));
		}
		if (locatortype.equals("css")) {
			el = driver.findElements(By.cssSelector(s1));
		}
		int size = el.size();
		return size;
	}

	public void slide(WebElement e, int xOffset, int yOffset) {
		action.dragAndDropBy(e, xOffset, yOffset);
		action.build().perform();
	}

	public void slide(WebElement e) {
		action.click().build().perform();
		for (int i = 0; i < 10; i++) {
			action.sendKeys(Keys.ARROW_RIGHT).build().perform();
		}
	}

	public String switchToNewWindow(WebElement e, String newWindowName) {
		String parentWindow = null;
		try {
			parentWindow = driver.getWindowHandle();
			e.click();
			Thread.sleep(3000);
			pageReadyState();
			Set<String> windowNames = driver.getWindowHandles();
			for (String names : windowNames) {
				if (!names.contains(parentWindow)) {
					String windowTitle = driver.switchTo().window(names).getTitle();
					if (windowTitle.contains(newWindowName)) {
						driver.manage().window().maximize();
						pageReadyState();
						break;
					}
				}
			}
		} catch (Exception e1) {
			System.out.println("");

		}
		return parentWindow;

	}

	public String switchToNewWindow(WebElement e) {
		String parentWindow = driver.getWindowHandle();
		e.click();
		pageReadyState();
		Set<String> windowNames = driver.getWindowHandles();
		for (String names : windowNames) {
			if (!names.contains(parentWindow)) {
				driver.switchTo().window(names);
				driver.manage().window().maximize();
				pageReadyState();
				break;
			}
		}
		return parentWindow;
	}

	public void switchToDefaultWindow(String defaultWindowName) {
		driver.close();
		driver.switchTo().window(defaultWindowName);
	}

	public void typeInAlertBox(String message) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(message);
		;
		alert.accept();
	}

	public void deleteFiles(String filePath, String fileName) {
		File directory = new File(filePath);
		File[] file = directory.listFiles();
		for (File f : file) {
			if (f.getName().contains(fileName)) {
				f.delete();
			}
		}
	}

	public void selectDropdown(WebElement e, String selectOption) {
		Select dropdown = new Select(e);
		dropdown.selectByVisibleText(selectOption);
	}

	public void selectDropdownOption_makingVisibleByScrollingDown(WebElement bodyElement,
			WebElement elementToBeSelected, String xpath_listOption) throws InterruptedException {
		user.click(bodyElement);
		int i = totalOption(xpath_listOption);
		for (int j = 0; j <= i; j++) {
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
		}
	}

	public int totalOption(String xpath) {
		List<WebElement> el = driver.findElements(By.xpath(xpath));
		int i = el.size();
		return i;
	}

	public void dragAndDropOperation(WebElement elementToBeDragged, WebElement draggedElementDestination) {
		action.dragAndDrop(elementToBeDragged, draggedElementDestination).build().perform();
	}

	public boolean isSubstring(String string1, String string2) {
		char c;
		char d;
		boolean match = true;
		for (int i = 0; i < string1.length(); i++) {
			c = string1.charAt(i);
			for (int j = 0; j < string2.length(); j++) {
				d = string2.charAt(j);
				if (c == d) {
					match = true;
					break;
				} else {
					match = false;
				}
			}
		}
		return match;
	}

	public boolean isListContainsOtherList(List<String> smallerList, List<String> biggerList) {
		boolean b = false;
		for (int i = 0; i < smallerList.size(); i++) {
			String s = smallerList.get(i);
			for (int j = 0; j < biggerList.size(); j++) {
				String s1 = biggerList.get(j);
				if (s1.contains(s)) {
					b = true;
					break;
				} else {
					b = false;
				}
			}
		}
		Assert.assertTrue(b);
		return b;
	}

}
