package com.guru.qa.testcases;

import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru.qa.Utilities.TestUtility;
import com.guru.qa.base.TestBase;
import com.guru.qa.pages.CommonFunctionUsage;

public class CommonFunctionUsageTest extends TestBase {
	
	CommonFunctionUsage commonFunctionUsage;
	String sheetName1 = "AutoCompleteSampleSheet";
	String sheetName2 = "DataFromSeleniumEasyURL";
			
	public CommonFunctionUsageTest() {
		super();
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		initialization();
		Log.info("Application Launched Successfully");
		commonFunctionUsage = new CommonFunctionUsage();
	}
	
	//To run below test case go to config.properties file and uncomment url = https://jqueryui.com/autocomplete/. comment all other url's
	@DataProvider
	public Object[][] getAutoCompleteTestData() throws InvalidFormatException {
		Object data[][] = TestUtility.getTestData(sheetName1);
		return data;
	}
	
	@Test(priority =1 , dataProvider = "getAutoCompleteTestData" )
	public void validateAutoCompleteDataFromExcel(String autoCompleteDDValue) throws InterruptedException {
		commonFunctionUsage.autoCompleteTB(autoCompleteDDValue);
	}
	
	
	//To run below set of test cases go to config.properties file and uncomment url = https://www.seleniumeasy.com/test/. comment all other url's
	/*@DataProvider
	public Object[][] getSeleEasyTestData() throws InvalidFormatException {
		Object data[][] = TestUtility.getTestData(sheetName2);
		return data;
	}
	
	@Test(priority = 1)
	public void verifyAlertHandling() throws InterruptedException {
		commonFunctionUsage.handleAlerts();
	}
	
	@Test(priority = 2 , dataProvider = "getSeleEasyTestData")
	public void verifyWindowsHandlingAndDatePicker(String childEmail, String datePickerValue) {
		commonFunctionUsage.handleWindowPopUp(childEmail);
		commonFunctionUsage.datePicker(datePickerValue);
	}*/
	
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}
}
