package com.guru.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.qa.base.TestBase;

public class NewCustomerPage extends TestBase {

	
	//Page Factory - OR for Home page
	
	@FindBy(xpath = "//input[@name = 'name']")
	WebElement CustomerName;
	
	@FindBy(xpath = "//input[@value= 'm']")
	WebElement GenderMale;
	
	@FindBy(xpath = "//input[@value= 'f']")
	WebElement GenderFemale;

	@FindBy(xpath = "//input[@id= 'dob']")
	WebElement DOB;
	/*DOB.clear();
	DOB.sendKeys("27111987");*/
	
	@FindBy(xpath = "//textarea[@name= 'addr']")
	WebElement Address;
	
	@FindBy(xpath = "//input[@name= 'city']")
	WebElement City;
	
	@FindBy(xpath = "//input[@name= 'state']")
	WebElement State;
	
	@FindBy(xpath = "//input[@name= 'pinno']")
	WebElement PinCode;
	
	@FindBy(xpath = "//input[@name= 'telephoneno']")
	WebElement MobNumber;
	
	@FindBy(xpath = "//input[@name= 'emailid']")
	WebElement EmailId;
	
	@FindBy(xpath = "//input[@name= 'password']")
	WebElement Password;
	
	@FindBy(xpath = "//input[@value= 'Submit']")
	WebElement SubmitBtn;
	
	@FindBy(xpath = "//input[@value= 'Reset']")
	WebElement ResetBtn;
	
	
	public NewCustomerPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createNewCustomer(String CustName,String gender,String dob,String DOB_Year,String add,String city,
			String state,String pinCode,String mobNo,String email,String password) {
				
		ResetBtn.click();
		CustomerName.sendKeys(CustName);
		GenderMale.sendKeys(gender);
		GenderFemale.sendKeys(gender);
		if(gender.equals("m")) {
			GenderMale.click();
		}
		else if(gender.equals("f")){
			GenderFemale.click();
		}
		DOB.clear();
		DOB.sendKeys(dob);
		DOB.sendKeys(Keys.ARROW_RIGHT);
		DOB.sendKeys(DOB_Year);
		Address.sendKeys(add);
		City.sendKeys(city);
		State.sendKeys(state);
		PinCode.sendKeys(pinCode);
		MobNumber.sendKeys(mobNo);
		EmailId.sendKeys(email);
		Password.sendKeys(password);
		
		SubmitBtn.click();
		
		//driver.switchTo().alert().accept();
		
		
	}
	
}
