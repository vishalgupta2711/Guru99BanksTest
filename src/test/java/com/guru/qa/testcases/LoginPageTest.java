package com.guru.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru.qa.base.TestBase;
import com.guru.qa.pages.HomePage;
import com.guru.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}

	@BeforeMethod()
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String Title = loginPage.validateLoginPageTitle();
		String ExpectedTitle = "Guru99 Bank Home Page";
		
		//Boolean flag = Assert.assertEquals(Title, "Guru99 Bank Home Page");
		if(	Title.equals(ExpectedTitle)) {
			System.out.println("Actual and Expected title are matching");
		}
		else {
			System.out.println("Title is not matching");
		}
	}
	
	@Test(priority = 2)
	public void loginPageLogoTest() {
		Boolean flag = loginPage.validateLoginPageLogo();
		Assert.assertTrue(flag);	
		System.out.println(flag);
	}
	
	@Test(priority = 3)
	public void loginPageLabelTest() {
		Boolean flag = loginPage.validateLoginPageLabel();
		Assert.assertTrue(flag);
		System.out.println(flag);
	}
	
	@Test(priority = 4)
	public void loginTest() {
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("Login Successful");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
