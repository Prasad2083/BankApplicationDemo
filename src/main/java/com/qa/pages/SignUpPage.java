package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.testbase.TestBaseClass;

public class SignUpPage extends TestBaseClass {
	
	
	@FindBy(id="firstName")
	WebElement fname;
	@FindBy(id="lastName")
	WebElement lname;
	@FindBy(xpath="//label[1]//*[@id=\"gender\"]")
	WebElement mgender;
	@FindBy(xpath="//label[2]//*[@id=\"gender\"]")
	WebElement fgender;
	@FindBy(xpath="//*[@id=\"dob\"]")
	WebElement dob;
	@FindBy(id="ssn")
	WebElement ssn;
	@FindBy(id="emailAddress")
	WebElement email;
	@FindBy(xpath="//*[@id=\"password\"]")
	WebElement password;
	@FindBy(xpath="//*[@id=\"confirmPassword\"]")
	WebElement cpassword;
	@FindBy(xpath="//button[contains(text(),'Next')]")
	WebElement submit;
	@FindBy(xpath="//*[@id=\"address\"]")
	WebElement address;
	@FindBy(xpath = "//*[@id=\"locality\"]")
	WebElement local;
	@FindBy(xpath = "//*[@id=\"region\"]")
	WebElement region;
	@FindBy(id="postalCode")
	WebElement postal;
	@FindBy(xpath="//*[@id=\"country\"]")
	WebElement countr;
	@FindBy(id="homePhone")
	WebElement mobile;
	@FindBy(id="agree-terms")
	WebElement agree;
	@FindBy(xpath="//*[contains(text(),'Register')]")
	WebElement register;
	

	public SignUpPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		
	}
	
    public void selectvaluesfordropdown(String value) {
		
		Select select = new Select(driver.findElement(By.xpath("//select[@id=\"title\"]")));
		select.selectByVisibleText(value);
		
	}
    
    
    
    public void male() {
    	mgender.click();
		
	}
    
    public void fmale() {
    	fgender.click();
		
	}
    
    public LoginPage Signupdetails(String firstname,String lastname,String birth,String emailaddr,String ssnumber,String pass,
    		String cpass,String addr,String loco,String regio,String code,String coun,String phone) throws IOException {
    	
    	fname.sendKeys(firstname);
    	lname.sendKeys(lastname);
    	dob.sendKeys(birth);
    	ssn.sendKeys(ssnumber);
    	email.sendKeys(emailaddr);
    	password.sendKeys(pass);
    	cpassword.sendKeys(cpass);
    	submit.click();
    	//return new AddressPage();
    	address.sendKeys(addr);
    	local.sendKeys(loco);
    	region.sendKeys(regio);
    	postal.sendKeys(code);
    	countr.sendKeys(coun);
    	mobile.sendKeys(phone);
    	agree.click();
    	register.click();
		return new LoginPage();	
    		
	}
    
   /* public void fillanotherdetails(String addr,String loco,String regio,String code,String coun)  {
    	
    	address.sendKeys(addr);
    	local.sendKeys(loco);
    	region.sendKeys(regio);
    	postal.sendKeys(code);
    	countr.sendKeys(coun);
    	//mobile.sendKeys(phone);
    	agree.click();
    	register.click();	
		
	}*/
    
    
    
	
	

}
