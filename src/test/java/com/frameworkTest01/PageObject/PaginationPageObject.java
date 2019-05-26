package com.frameworkTest01.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.frameworkTest01.test.baseClass;

public class PaginationPageObject extends baseClass {

	@FindBy(how = How.XPATH, using = "//a[@data-toggle='dropdown'][contains(text(),'Table')]")
	public WebElement dropDown_Table;

	public String link_next = "a[class='next_link'][style$='block;']";

	public WebElement dropdown_FieldName(String s1, WebDriver driver) {
		WebElement e1 = driver.findElement(
				By.xpath("//li[normalize-space(@data-toggle='dropdown')]//li[not(@style)]//a[text()='" + s1 + "']"));
		return e1;
	}

	@FindBy(how = How.CSS, using = "a[class='next_link'][style$='block;']")
	public WebElement link_Next;

	@FindBy(how = How.XPATH, using = "//a[@class='next_link']")
	public WebElement link_Next1;

	public List<WebElement> paginationLastPage() {
		List<WebElement> el = driver.findElements(By.xpath("//ul[@id='myPager']//a[contains(@class,'page_link')]"));
		return el;
	}

	@FindBy(how = How.CSS, using = "input[id*='table-filter']")
	public WebElement field_Filter;

	public By searchedItem(String columnName) {
		By xpath = By.xpath(
				"//table[@id='task-table']//tr[not(contains(@style,'none'))]//td[count(//table[@id='task-table']//th[text()='"
						+ columnName + "']/preceding-sibling::th)+1]");
		return xpath;
	}

	public List<WebElement> totalSearchResult(String columnHeaderName) {
		List<WebElement> el = driver.findElements(searchedItem(columnHeaderName));
		return el;
	}

	public WebElement ascendingIcon(String columnName) {
		By xpath = By.xpath("//thead[@class='thead-inverse']//th[text()='" + columnName + "']");
		WebElement e = driver.findElement(xpath);
		return e;
	}

	public List<WebElement> totalSortedResult_TableSearchAndSort() {
		List<WebElement> el = driver
				.findElements(By.xpath("//table[@id='example']//tbody//tr//td[@class='sorting_1']"));
		return el;
	}

	@FindBy(how = How.XPATH, using = "//a[@data-toggle='dropdown'][contains(text(),'Progress Bars')]")
	public WebElement dropDown_ProgressBar;

	@FindBy(how = How.XPATH, using = "//a[@data-toggle='dropdown'][contains(text(),'Alerts & Modals')]")
	public WebElement dropDown_AlertModel;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'range-success')]//input")
	public WebElement progressBar_Green;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Multiple Modal Example')]/ancestor::div[1]//a[contains(text(),'Launch modal')][(@href='#myModal')]")
	public WebElement launchModal_MultipleModal;
	
	@FindBy(how = How.XPATH, using = "//div[@class='modal-body']//a[contains(text(),'Launch modal')]")
	public WebElement launchModal_FirstModal;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'modal fade rotate')]//button[@class='close']")
	public WebElement closeIcon_Modal2;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'modal fade rotate')]//button[@class='close']")
	public WebElement closeButton_FirstModal;
	
	public WebElement multipleWindowModal(String modalName) {
		By xpath = By.xpath("//a[contains(text(),'" + modalName + "')]");
		WebElement e = driver.findElement(xpath);
		return e;
	}
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Phone')]")
	public WebElement fieldPhone;
	
	public WebElement promtBox(String boxName) {
		By xpath = By.xpath("//button[text()='" + boxName + "']");
		WebElement e = driver.findElement(xpath);
		return e;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='form-group']//textarea[@id='textbox']")
	public WebElement textField_enterData;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Generate File']")
	public WebElement button_GenerateFile;
	
	@FindBy(how = How.XPATH, using = "//a[@id='link-to-download']")
	public WebElement button_Download;
	
	@FindBy(how = How.XPATH, using = "//a[@data-toggle='dropdown'][contains(text(),'List Box')]")
	public WebElement dropDown_ListBox;
	
	@FindBy(how = How.XPATH, using = "//select[contains(@class,'pickListSelect pickData')]")
	public WebElement select_Picklist;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Add']")
	public WebElement button_Add;
	
	public WebElement select_PicklistElement(String elementName) {
		By xpath = By.xpath("//select[contains(@class,'pickListSelect pickData')]//option[text()='" + elementName + "']");
		WebElement e = driver.findElement(xpath);
		return e;
	}
	
	public String xpath_picklistOption = "//select[contains(@class,'pickListSelect pickData')]//option";
	
	@FindBy(how = How.XPATH, using = "//a[@data-toggle='dropdown'][contains(text(),'Others')]")
	public WebElement dropdown_Others;
	
	public WebElement itemToDrag(String elementName) {
		By xpath = By.xpath("//div[@id='todrag']//span[text()='" + elementName + "']");
		WebElement e = driver.findElement(xpath);
		return e;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='mydropzone']")
	public WebElement dragedElementDestination;
	
	public List<WebElement> listDropdownElements() {
		List<WebElement> el = driver
				.findElements(By.xpath("//select[contains(@class,'pickListSelect pickData')]//option"));
		return el;
	}

}
