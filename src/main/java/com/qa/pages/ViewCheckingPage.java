package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBaseClass;

public class ViewCheckingPage extends TestBaseClass {

	@FindBy(how=How.XPATH,using="//div[contains(text(),'First_Deploy')]")
	   WebElement verifyicon1;
	@FindBy(how=How.LINK_TEXT,using="Checking")
	   WebElement checklink;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'View Checking')]")
	   WebElement viwclick;
	@FindBy(how=How.XPATH,using="//*[@id=\"firstRow\"]/div[1]/div/form/div/label/span[1]")
	WebElement toggle1;

	
	public ViewCheckingPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	/*public ViewCheckingPage viewcheckpage() throws IOException {
		
		checklink.click();
		
		viwclick.click();
		
		return new ViewCheckingPage();
		
	}*/
	
	
	public void toggleclick1() {
        checklink.click();
		viwclick.click();
		toggle1.click();
		
	}
	
	public String icon1() {
        checklink.click();
		viwclick.click();
		String ic1=verifyicon1.getText();
		return ic1;
		
	}
	
}
