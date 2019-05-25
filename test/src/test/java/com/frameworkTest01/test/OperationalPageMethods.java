package com.frameworkTest01.test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

public class OperationalPageMethods extends baseClass {

	String parentWindowname = null;

	@Then("^navigate to last page$")
	public void navigate_to_last_page() throws Throwable {
		int lastPageNumber = pagination.paginationLastPage().size();
		boolean flag = false;
		for (int i = 1; i <= lastPageNumber; i++) {
			user.click(pagination.link_Next1);
			if (lastPageNumber - 1 == i) {
				i = i + 1;
				By a = By.xpath(
						"//ul[@id='myPager']//a[contains(@class,'page_link')][text()='" + i + "']/ancestor::li[1]");
				flag = driver.findElement(a).getAttribute("class").contains("active");
			}
		}
		Assert.assertEquals(true, flag);
	}

	@Then("^click on filter field$")
	public void click_on_filter_field() throws Throwable {
		user.click(pagination.field_Filter);
	}

	@Then("^enter to be filter value \"([^\"]*)\"$")
	public void enter_to_be_filter_value(String arg1) throws Throwable {
		user.type(pagination.field_Filter, arg1);
	}

	@Then("^verify if search result is filtered by text \"([^\"]*)\" or \"([^\"]*)\" for column header \"([^\"]*)\"$")
	public void verify_if_search_result_is_filtered_by_text_or_for_column_header(String searchableValue1,
			String searchableValue2, String columnHeaderName) throws Throwable {
		int searchedFileCount = pagination.totalSearchResult(columnHeaderName).size();
		for (int i = 0; i < searchedFileCount; i++) {
			String textSearchedResult = pagination.totalSearchResult(columnHeaderName).get(i).getText();
			Assert.assertTrue(
					textSearchedResult.contains(searchableValue1) || textSearchedResult.contains(searchableValue2));
		}
	}

	@Then("^select decending order icon in \"([^\"]*)\"$")
	public void select_decending_order_icon_in(String columnName) throws Throwable {
		String attributeValue = user.getAttribute(pagination.ascendingIcon(columnName), "aria-sort");
		if (attributeValue.equalsIgnoreCase("ascending")) {
			user.click(pagination.ascendingIcon(columnName));
		}
		List<String> sortedResult = new ArrayList<>();
		int totalSortedValue = pagination.totalSortedResult_TableSearchAndSort().size();
		for (int i = 0; i < totalSortedValue; i++) {
			String sortedResultValue = pagination.totalSortedResult_TableSearchAndSort().get(i).getText();
			sortedResult.add(sortedResultValue);
		}

		for (int i = sortedResult.size() - 1; i > 0; i--) {
			int compareValue;
			compareValue = sortedResult.get(i).compareTo(sortedResult.get(i - 1));
			Assert.assertTrue(compareValue < 0);
		}

	}

	@Then("^complete sliding operation on green slider$")
	public void complete_sliding_operation_on_green_slider() throws Throwable {
		user.slide(pagination.progressBar_Green);
	}

	@Then("^click launch modal of \"([^\"]*)\"$")
	public void click_launch_modal_of(String arg1) throws Throwable {
		user.click(pagination.launchModal_MultipleModal);

	}

	@Then("^again click on launch modal$")
	public void again_click_on_launch_modal() throws Throwable {
		user.click(pagination.launchModal_FirstModal);
	}

	@Then("^cancel model (\\d+)$")
	public void cancel_model(int arg1) throws Throwable {
		user.click(pagination.closeIcon_Modal2);
	}

	@Then("^close (\\d+)st model$")
	public void close_st_model(int arg1) throws Throwable {
		user.click(pagination.closeButton_FirstModal);
	}

	@Then("^click on \"([^\"]*)\"$")
	public void click_on(String modalName) throws Throwable {
		user.click(pagination.multipleWindowModal(modalName));
	}

	@Then("^navigate to new window \"([^\"]*)\"$")
	public void navigate_to_new_window(String newWindowName) throws Throwable {
		parentWindowname = user.switchToNewWindow(pagination.multipleWindowModal("Follow Twitter & Facebook"),
				newWindowName);
	}

	@Then("^validate if navigated to Selenium easy page$")
	public void validate_if_navigated_to_Selenium_easy_page() throws Throwable {
		user.typeWithoutClearing(pagination.fieldPhone, "test");
	}

	@Then("^navigate back to parent page$")
	public void navigate_back_to_parent_page() throws Throwable {
		user.switchToDefaultWindow(parentWindowname);
	}

	@Then("^click on promt box \"([^\"]*)\"$")
	public void click_on_promt_box(String boxName) throws Throwable {
		user.click(pagination.promtBox(boxName));
	}

	@Then("^enter text \"([^\"]*)\" in javascript promt box$")
	public void enter_text_in_javascript_promt_box(String message) throws Throwable {
		user.typeInAlertBox(message);
	}

	@Then("^click on enter data and enter data \"([^\"]*)\"$")
	public void click_on_enter_data_and_enter_data(String arg1) throws Throwable {
		user.type(pagination.textField_enterData, arg1);
	}

	@Then("^click on generate file button$")
	public void click_on_generate_file_button() throws Throwable {
		user.click(pagination.button_GenerateFile);
	}

	@Then("^click on Download button$")
	public void click_on_Download_button() throws Throwable {
		String userName = System.getProperty("user.name");
		user.deleteFiles("C:/Users/" + userName + "/Downloads", "easyinfo");
		user.click(pagination.button_Download);
	}

	@Then("^verify entered text \"([^\"]*)\" is present in downloaded text file$")
	public void verify_entered_text_is_present_in_downloaded_text_file(String arg1) throws Throwable {
		List<String> lt = new ArrayList<String>();
		Thread.sleep(4000);
		lt = propertiesclass.readTextFile("C:/Users/shubham/Downloads/easyinfo.txt");
		Assert.assertTrue(lt.contains(arg1));
	}

	@Then("^select \"([^\"]*)\" from pick list$")
	public void select_from_pick_list(String arg1) throws Throwable {
		user.selectDropdownOption_makingVisibleByScrollingDown(pagination.select_Picklist,
				pagination.select_PicklistElement(arg1), pagination.xpath_picklistOption);
		user.selectDropdown(pagination.select_Picklist, arg1);
	}

	@Then("^click on add button$")
	public void click_on_add_button() throws Throwable {
		user.click(pagination.button_Add);
	}

	@Then("^select items to drag \"([^\"]*)\" and drop into Drop here$")
	public void select_items_to_drag_and_drop_into_Drop_here(String arg1) throws Throwable {
		user.dragAndDropOperation(pagination.itemToDrag(arg1), pagination.dragedElementDestination);
	}

	@Then("^validate following fields present in select dropdown$")
	public void validate_following_fields_present_in_select_dropdown(DataTable arg1) throws Throwable {
		List<String> expectedDropdownOption = arg1.asList(String.class);
		List<String> actualDropdownOption = new ArrayList<String>();
		int sizeActualDropdownElements = pagination.listDropdownElements().size();
		for (int i = 0; i < sizeActualDropdownElements; i++) {
			String elementsName_Actual = pagination.listDropdownElements().get(i).getText();
			actualDropdownOption.add(elementsName_Actual);
		}
		user.isListContainsOtherList(expectedDropdownOption, actualDropdownOption);
		
	}

}
