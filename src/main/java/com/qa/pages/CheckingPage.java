package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBaseClass;

public class CheckingPage extends TestBaseClass {
	
	
	
	//New Checking Page in HomePage
	
	@FindBy(how=How.LINK_TEXT,using="Checking")
	   WebElement checklink;
	@FindBy(how=How.LINK_TEXT,using="New Checking")
	   WebElement newcheckinglink;
	@FindBy(how=How.XPATH,using="//*[contains(text(),'New Checking Account')]")
	   WebElement checkingnewchecktitile;
	@FindBy(how=How.XPATH,using="//*[@id=\"Standard Checking\"]")
	   WebElement clickstandard;
	   @FindBy(how=How.XPATH,using="//*[@id=\"Individual\"]")
	   WebElement clickindividual;
	   @FindBy(how=How.XPATH,using="//*[@id=\"name\"]")
	   WebElement accountname;
	   @FindBy(how=How.XPATH,using="//*[@name=\"openingBalance\"]")
	   WebElement depostbalnce;
	   @FindBy(how=How.XPATH,using="//div[@class=\"card-footer\"]//button[@type=\"submit\"]")
	   WebElement submitlink;
	   @FindBy(how=How.XPATH,using="//*[@id=\"Interest Checking\"]")
	   WebElement clickinterest;
	   @FindBy(how=How.XPATH,using="//*[@id=\"Joint\"]")
	   WebElement accuntjoint;
	   @FindBy(how=How.XPATH,using="//*[contains(text(),'Reset')]")
	   WebElement reset;
	   
	   
	   @FindBy(how=How.XPATH,using="//*[contains(text(),'Transactions')]")
	   WebElement transctext; 

	public CheckingPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	public String NCA() {
		checklink.click();
		newcheckinglink.click();
		return checkingnewchecktitile.getText();
	}
	
	public void Standardcheck() {
		checklink.click();
		newcheckinglink.click();
		clickstandard.click();
		clickindividual.click();
		accountname.sendKeys("NewCustomer");
		depostbalnce.sendKeys("1000");
		submitlink.click();
		
	}
	
	public void InterestCheck() {
		checklink.click();
		newcheckinglink.click();
		clickinterest.click();
		accuntjoint.click();
		accountname.sendKeys("NewCustomer1");
		depostbalnce.sendKeys("1600");
		submitlink.click();
		
	}
	public void Reset() {
		
		checklink.click();
		newcheckinglink.click();
		clickinterest.click();
		accuntjoint.click();
		accountname.sendKeys("NewCustomer12222");
		depostbalnce.sendKeys("1600");
		reset.click();
		
		
		
		
	}
	
	

}
