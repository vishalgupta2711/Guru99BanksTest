package com.guru.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru.qa.base.TestBase;
import com.guru.qa.pages.DepositPage;
import com.guru.qa.pages.HomePage;
import com.guru.qa.pages.LoginPage;
import com.guru.qa.util.TestUtil;

public class DepositPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	DepositPage depositPage;
	
	String sheetName = "Deposit";
	//String Ad = "//*[@id=\"transparentInner\"]";
	
	public DepositPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
		depositPage = new DepositPage();
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		//below code is for scrolling down the page.
		/*Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");*/
		
		depositPage = homePage.clickOnDepositLink();
	}
	
	@DataProvider
	public Object[][] getGuru99DepositTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 1 , dataProvider = "getGuru99DepositTestData")
	public void validateDepositTestData(String depAcct ,String depAmt ,String depDesc ) throws IOException {
		
		depositPage.getDepositData(depAcct, depAmt, depDesc);
		TestUtil.takeScreenshotAtEndOfTest();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
