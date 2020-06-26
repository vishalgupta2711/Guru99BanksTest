package com.guru.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru.qa.util.Xls_Reader;
import com.guru.qa.base.TestBase;
import com.guru.qa.pages.HomePage;
import com.guru.qa.pages.LoginPage;
import com.guru.qa.pages.NewCustomerPage;
import com.guru.qa.util.TestUtil;

public class NewCustomerPageTest extends TestBase {

	
	LoginPage loginPage;
	HomePage homePage;
	NewCustomerPage newCustomerPage;
	String sheetName = "NewCustomers";
	int rowNumber =2;
	
	public NewCustomerPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		homePage = new HomePage();
		newCustomerPage = new NewCustomerPage();
		loginPage = new LoginPage();
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		newCustomerPage = homePage.clickOnNewCustomerlink();
	}
	
	@DataProvider
	public Object[][] getGuru99NewCustomerTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 1 , dataProvider = "getGuru99NewCustomerTestData")
	public void validateNewCustomerTestData(String CustName,String gender,String dob,String DOB_Year,String add,String city,
			String state,String pinCode,String mobNo,String email,String password) throws IOException {
		
		newCustomerPage.createNewCustomer(CustName, gender, dob, DOB_Year, add, city, state, pinCode,
				mobNo, email, password);
		
		NewCustomerPage.printDataOnExcel(rowNumber);
		rowNumber++;
		TestUtil.takeScreenshotAtEndOfTest();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
