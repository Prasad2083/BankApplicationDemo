package com.qa.pages;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBaseClass;
import com.qa.testutils.ExcelPractice;

public class LoginPage extends TestBaseClass{
	

	
	ExcelPractice datalogin;
	
	//PageFactory of the Page Login or Object Repo of the Login page Where all the elements are declared with their locators
	
	@FindBy(id="username")
	
	WebElement usern;
	
	@FindBy(xpath="//*[@id=\"password\"]")

	WebElement passn;
	
	@FindBy(id="submit")
	
	WebElement loginbtn;
	
	@FindBy(xpath="//a[contains(text(),' Sign Up Here')]")
	WebElement signbtn;
	
	@FindBy(xpath="//span[contains(text(),'Error')]")
	
	WebElement errormsg1;
	
	@FindBy(xpath="//span[contains(text(),'Error')]")
	WebElement errormsg2;
	
	
	
      
	//Initialize the locators of the web elements by declaring a login page constructor
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	// Actions of the LoginPage class
	
	public String gettitleofthepage() {
		
		System.out.println(driver.getTitle());
		
		return driver.getTitle();	
	}
	
	public SignUpPage tosignup() throws IOException {
		signbtn.click();
		return new SignUpPage();
		
	}
	
	
	public String checkingloginpage(String username,String Password) throws IOException {
		
		usern.sendKeys(username);
		passn.sendKeys(Password);
		loginbtn.click();
		String er= errormsg1.getText();
		return er;		
	}
	
	public HomePage checkingexcel(String username,String Password) throws IOException {
		
		usern.sendKeys(username);
		passn.sendKeys(Password);
		loginbtn.click();
		return new HomePage();	
	}
	
		
	}

	
	
	


