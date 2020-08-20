package com.guru.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru.qa.base.TestBase;
import com.guru.qa.pages.CommonFunctionUsage;

public class CommonFunctionUsageTest extends TestBase {
	
	CommonFunctionUsage commonFunctionUsage;
	
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
	/*@Test(priority = 1)
	public void verifyAutoCompleteTest() throws InterruptedException {
		commonFunctionUsage.autoCompleteTB();
	}*/
	
	//To run below set of test cases go to config.properties file and uncomment url = https://www.seleniumeasy.com/test/. comment all other url's
	@Test(priority = 1)
	public void verifyAlertHandling() throws InterruptedException {
		commonFunctionUsage.handleAlerts();
	}
	
	@Test(priority = 2)
	public void verifyWindowsHandling() {
		commonFunctionUsage.handleWindowPopUp();
	}
	
	@Test(priority = 3)
	public void verifyDatePicker() {
		commonFunctionUsage.datePicker();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
