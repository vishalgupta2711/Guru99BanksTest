package com.guru.qa.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MandatoryFields {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rishtadilka.com/register.registerstep0");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement NameLbl = driver.findElement(By.xpath("//h3[contains(text(),'Name')]"));
		WebElement MobLbl = driver.findElement(By.xpath("//h3[contains(text(),'Mobile')]"));
		WebElement LookingLbl = driver.findElement(By.xpath("//h3[contains(text(),'Looking for ')]"));
		WebElement GenderLbl = driver.findElement(By.xpath("//h3[contains(text(),'Gender')]"));
		checkMandatoryFields(NameLbl,MobLbl,LookingLbl,GenderLbl);
		System.out.println("****************************************************************************");
		startingWith(NameLbl,MobLbl,LookingLbl,GenderLbl);
	}

	public static void checkMandatoryFields(WebElement NameLbl,WebElement MobLbl,WebElement LookingLbl,WebElement GenderLbl) {
		
		ArrayList<WebElement> list = new ArrayList<WebElement>(); 
			  list.add(NameLbl);
			  list.add(MobLbl);
			  list.add(LookingLbl);
			  list.add(GenderLbl);
			  System.out.println("\nTotal number of mandatory fields are : " +list.size()+ "\n");
			  for(int j=0 ; j<list.size() ; j++) {
				  if(list.get(j).getText().contains("*")) {
					  System.out.println(list.get(j).getText());
				  }
			  }
			  System.out.println("execute your function here");
		/*List<WebElement> MandatoryElementList = driver.findElements(By.xpath("//span[contains(text(),'*')]"));
		System.out.println(MandatoryElementList.size());
		for(int i=0 ; i<MandatoryElementList.size() ; i++) {
			if(MandatoryElementList.get(i).isDisplayed()) {
				System.out.println("All mandatory fields present"); //if all the mandatory fields are present then execute the statements you require else execute the statements you require or break the loop
				System.out.println(MandatoryElementList.get(i).getText());
			}
			else {
				System.out.println("All mandatory fields are not present");
			}
		}*/
	}
	public static void startingWith(WebElement NameLbl,WebElement MobLbl,WebElement LookingLbl,WebElement GenderLbl) {
		ArrayList<WebElement> list = new ArrayList<WebElement>(); 
		  list.add(NameLbl);
		  list.add(MobLbl);
		  list.add(LookingLbl);
		  list.add(GenderLbl);
		  System.out.println("\nTotal number of mandatory fields are : " +list.size()+ "\n");
		  for(int j=0 ; j<list.size() ; j++) {
			  if(list.get(j).getText().startsWith("N")) {
				  System.out.println(list.get(j).getText());
				  break;
			  }
			  else {
				  System.out.println("Other labels are not starting with N");
			  }
			
		  }
		
	}
}
