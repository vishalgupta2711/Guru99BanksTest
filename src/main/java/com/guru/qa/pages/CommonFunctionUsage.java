package com.guru.qa.pages;

import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.qa.Constants.Constants;
import com.guru.qa.Utilities.JavaScriptUtilities;
import com.guru.qa.Utilities.TestUtility;
import com.guru.qa.base.TestBase;

public class CommonFunctionUsage extends TestBase {

	@FindBy(css = "#tags.ui-autocomplete-input")
	WebElement autoCompleteTagsTB;
	
	@FindBy(xpath = "//ul[@id=\"ui-id-1\"]//li")
	WebElement autoCompleteTagsTBList;
	
	@FindBy(xpath = "//div[@id = 'sidebar']//li/a[contains(text(),'Selectmenu')]")
	WebElement SelectMenuLink;
	
	@FindBy(xpath = "//span[@id = 'files-button']")
	WebElement SelectAFileDD;
	
	@FindBy(xpath = "//div[@id = 'sidebar']//li/a[contains(text(),'Selectable')]")
	WebElement SelectableLink;
	
	@FindBy(xpath = "(//a[contains(text(),'Alerts & Modals')])[2]")
	WebElement AlertsBtn;
	
	@FindBy(xpath = "(//a[contains(text(),'Javascript Alerts')])[2]")
	WebElement JavaScriptAlertsBtn;
	
	@FindBy(xpath = "(//a[contains(text(),'Window Popup Modal')])[2]")
	WebElement WindowPopupModalBtn;
	
	@FindBy(xpath = "//a[contains(text(),'  Like us On Facebook ')]")
	WebElement LikeUsOnFBBtn;
	
	@FindBy(xpath = "(//input[@id='email'])[1]")
	WebElement ChildWindowEmailField;
	
	@FindBy(xpath = "(//a[contains(text(),'Date pickers')])[2]")
	WebElement datePickerBtn;
	
	@FindBy(xpath = "(//a[contains(text(),'Bootstrap Date Picker')])[2]")
	WebElement BootStrapdatePickerBtn;
	
	@FindBy(xpath = "//input[@placeholder='dd/mm/yyyy']")
	WebElement dateSelectField;
	
	@FindBy(css = "#easycont > div > div.col-md-6.text-left > div:nth-child(4) > div.panel-body > button")
	WebElement JavaScriptClickMe;
	
	public CommonFunctionUsage() {
		
		//the below statement means that all 'this' above WebElement object will get initialized with 'driver' which is present in the base class 
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void autoCompleteTB(String autoCompleteDDValue) throws InterruptedException {
		
		
		TestUtility.switchToFrame(0); //Switching to frame with index
		TestUtility.sendKeys(driver, autoCompleteTagsTB, Constants.SHORT_WAIT, autoCompleteDDValue); //function to sendkeys to textboxes
		
		if(autoCompleteDDValue.equals(Constants.AutoPopUpValueJavaScript)) {
			TestUtility.selectDropDownValue(Constants.ListDropdownLocator, Constants.AutoPopUpValueJavaScript); //Function to select bootstrap dropdown values
		}
		else if(autoCompleteDDValue.equals(Constants.AutoPopUpValueJava)){
			TestUtility.selectDropDownValue(Constants.ListDropdownLocator, Constants.AutoPopUpValueJava);
		}
		
		driver.switchTo().defaultContent();
		
		JavaScriptUtilities.clickElementByJavaScript(SelectMenuLink, driver); //clicking on element by javascript
		TestUtility.switchToFrame(0);
		JavaScriptUtilities.clickElementByJavaScript(SelectAFileDD, driver);
		TestUtility.selectDropDownValue(Constants.SelectaFileDDLocator, Constants.SelectaFileDDValue);
	}
	
	public void handleAlerts() throws InterruptedException {
		
		JavaScriptUtilities.clickElementByJavaScript(AlertsBtn, driver);
		JavaScriptUtilities.clickElementByJavaScript(JavaScriptAlertsBtn, driver);
		JavaScriptUtilities.clickElementByJavaScript(JavaScriptClickMe, driver);
		TestUtility.acceptAlertPopup(); //Function for handling AlertPopups
	}
	
	public void handleWindowPopUp(String childEmail) {
		
		JavaScriptUtilities.clickElementByJavaScript(WindowPopupModalBtn, driver);
		JavaScriptUtilities.clickElementByJavaScript(LikeUsOnFBBtn, driver);
		
		String parentWindow = driver.getWindowHandle();
		TestUtility.switchWindow(driver, parentWindow, "");	//Function to switch to different window 
		TestUtility.sendKeys(driver, ChildWindowEmailField, Constants.SHORT_WAIT, childEmail);  //just to confirm if control switched to child window
		driver.close();
		driver.switchTo().window(parentWindow);		        // To go back to the parent window
	}
	
	public void datePicker(String datePickerValue) {
		
		JavaScriptUtilities.clickElementByJavaScript(datePickerBtn, driver);
		JavaScriptUtilities.clickElementByJavaScript(BootStrapdatePickerBtn, driver);
		TestUtility.sendKeys(driver, dateSelectField, Constants.SHORT_WAIT, datePickerValue);
	}
	
}
