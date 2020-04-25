package com.guru.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru.qa.base.TestBase;
import com.guru.qa.pages.DepositPage;
import com.guru.qa.pages.HomePage;
import com.guru.qa.pages.LoginPage;
import com.guru.qa.pages.NewAccountPage;
import com.guru.qa.pages.NewCustomerPage;

public class HomePageTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	NewCustomerPage newCustomerPage;
	NewAccountPage newAccountPage;
	DepositPage depositPage;
	
	//calling TestBase class constructor to initialize the property class 
	public HomePageTest() {
		super();
	}

	@BeforeTest
	public void setUp() {
		
		initialization();
		newCustomerPage = new NewCustomerPage();
		newAccountPage = new NewAccountPage();
		depositPage = new DepositPage();
		loginPage = new LoginPage();
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	@Test(priority = 1)
	public void validateSeleniumBtnTest() {
		Boolean flag = homePage.validateSeleniumProjBtnDisplay();
		Assert.assertTrue(flag);
		System.out.println(flag);
	}
	
	@Test(priority = 2)
	public void validateInsPrjBtnTest() {
		Boolean flag = homePage.validateInsProjBtnDisplay();
		Assert.assertTrue(flag);
		System.out.println(flag);
	}
	
	@Test(priority = 3)
	public void validateAgilePrjBtnTest() {
		Boolean flag = homePage.validateAgileProjBtnDisplay();
		Assert.assertTrue(flag);
		System.out.println(flag);
	}
	
	@Test(priority = 4)
	public void validateBankPrjBtnTest() {
		Boolean flag = homePage.validateBankProjBtnDisplay();
		Assert.assertTrue(flag);
		System.out.println(flag);
	}
	
	@Test(priority = 5)
	public void validateSecPrjBtnTest() {
		Boolean flag = homePage.validateSecurityProjBtnDisplay();
		Assert.assertTrue(flag);
		System.out.println(flag);
	}
	
	@Test(priority = 6)
	public void validateTcomPrjBtnTest() {
		Boolean flag = homePage.validateTcomProjBtnDisplay();
		Assert.assertTrue(flag);
		System.out.println(flag);
	}
	
	@Test(priority = 7)
	public void validatePayGatPrjBtnTest() {
		Boolean flag = homePage.validateAPayGateProjBtnDisplay();
		Assert.assertTrue(flag);
		System.out.println(flag);
	}
	
	@Test(priority = 8)
	public void validateNewToursPrjBtnTest() {
		Boolean flag = homePage.validateNewTourseProjBtnDisplay();
		Assert.assertTrue(flag);
		System.out.println(flag);
	}
	
	@Test(priority = 9)
	public void validateSEOBtnTest() {
		Boolean flag = homePage.validateSEOProjBtnDisplay();
		Assert.assertTrue(flag);
		System.out.println(flag);
	}
	
	
//************************Test Cases for left side vertical bar**************************
	
	@Test(priority = 10)
	public void clickOnNewCustomerLinkTest() {
		newCustomerPage = homePage.clickOnNewCustomerlink();
	}
	
	@Test(priority = 11)
	public void clickOnNewAccountPageTest() {
		newAccountPage = homePage.clickOnNewAccountLink();
	}
	
	@Test(priority = 12)
	public void clickOnDepositPageTest() throws InterruptedException {
		depositPage = homePage.clickOnDepositLink();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
