package com.guru.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru.qa.base.TestBase;
import com.guru.qa.pages.HomePage;
import com.guru.qa.pages.LoginPage;
import com.guru.qa.pages.NewAccountPage;
import com.guru.qa.util.TestUtil;

public class NewAccountPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	NewAccountPage newAccountPage;
	String sheetName = "NewAccounts";
	public NewAccountPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
		newAccountPage = new NewAccountPage();
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		newAccountPage = homePage.clickOnNewAccountLink();
	}
	
	
	@DataProvider
	public Object[][] getGuru99NewAccountTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority =1 , dataProvider = "getGuru99NewAccountTestData")
	public void validateNewAccountTestData (String custId, String AccountType
			, String initDeposit) throws IOException {
		newAccountPage.addNewAccount(custId,AccountType ,initDeposit);
		TestUtil.takeScreenshotAtEndOfTest();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
