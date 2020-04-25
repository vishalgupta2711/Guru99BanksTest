package com.guru.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//Page Factory - OR for Home page
	
	//Horizontal bar buttons
	
	@FindBy(xpath = "//a[contains(text(),'Insurance Project')]")
	WebElement InsProjBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Agile Project')]")
	WebElement AgileProjBtn;
	
	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul/li[5]/a")
	WebElement BankProjBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Security Project')]")
	WebElement SecurityProjBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Telecom Project')]")
	WebElement TcomProjBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Payment Gateway Project')]")
	WebElement PayGateProjBtn;
	
	@FindBy(xpath = "//a[contains(text(),'New Tours Project')]")
	WebElement NewToursProjBtn;
	
	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul/li[11]/a")
	WebElement SEOBtn;
	
	@FindBy(xpath = "//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a")
	WebElement SeleniumBtn;
	
	//Vertical bar buttons
	
	@FindBy(xpath ="//a[contains(text(),'New Customer')]")
	WebElement NewCustomerBtn;
	
	@FindBy(xpath ="//a[contains(text(),'New Account')]")
	WebElement NewAcctBtn;
	
	@FindBy(xpath ="//a[contains(text(),'Deposit')]")
	WebElement DepositBtn;
	
	@FindBy(xpath = "//div[@id = 'closeBtn']")
	WebElement CloseAdBtn;
	
	@FindBy(xpath = "//div[@id = 'transparentInner']")
	WebElement Ad;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public boolean validateInsProjBtnDisplay() {
		return InsProjBtn.isDisplayed();
	}
	
	public boolean validateAgileProjBtnDisplay() {
		return AgileProjBtn.isDisplayed();
	}
	
	public boolean validateBankProjBtnDisplay() {
		return BankProjBtn.isDisplayed();
	}
	public boolean validateSecurityProjBtnDisplay() {
		return SecurityProjBtn.isDisplayed();
	}
	
	public boolean validateTcomProjBtnDisplay() {
		return TcomProjBtn.isDisplayed();
	}
	
	public boolean validateAPayGateProjBtnDisplay() {
		return PayGateProjBtn.isDisplayed();
	}
	
	public boolean validateNewTourseProjBtnDisplay() {
		return NewToursProjBtn.isDisplayed();
	}
	
	public boolean validateSEOProjBtnDisplay() {
		return SEOBtn.isDisplayed();
	}
	
	public boolean validateSeleniumProjBtnDisplay() {
		return SeleniumBtn.isDisplayed();
	}
	
	
	//*****************************************************************
	//Below functions are for the buttons/pages on the left side vertical bar
	
	public NewCustomerPage clickOnNewCustomerlink() {
		NewCustomerBtn.click();
		return new NewCustomerPage();
	}
	
	public NewAccountPage clickOnNewAccountLink() {
		NewAcctBtn.click();
		return new NewAccountPage();
	}
	
	public DepositPage clickOnDepositLink() throws InterruptedException {
		
		DepositBtn.click();
		return new DepositPage();
	}
}
