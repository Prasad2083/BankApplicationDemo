package com.qa.pages;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.testbase.TestBaseClass;

public class HomePage extends TestBaseClass {
	
	   @FindBy(xpath="//*[@id=\"right-panel\"]/div[1]/div[2]")
	   static WebElement verifyome;
	   @FindBy(xpath="//*[@id=\"message\"]")
	   WebElement simage;
	   @FindBy(how=How.ID,using="aboutLink")
	   WebElement version2;
	   @FindBy(how=How.XPATH,using="//*[@id=\"aboutModal\"]/div/div/div[2]/p") 
	   WebElement vername1;
	   @FindBy(how=How.XPATH,using="//*[@class=\"close\"]")
	   WebElement vercls;
	   @FindBy(how=How.XPATH,using="//*[@id=\"header\"]/div/div[2]/div[1]")
	   List<WebElement> allelements;
	   @FindBy(how=How.XPATH,using="//h3[contains(text(),'Banking Accounts')]")
	   WebElement sidetitle;
	   @FindBy(how=How.LINK_TEXT,using="home")
	   WebElement homepageide;
	   @FindBy(how=How.XPATH,using="//h4[contains(text(),'Account Balance Summary')]")
	   WebElement accountstring;
	   @FindBy(how=How.XPATH,using="//h4[contains(text(),'Deposit vs. Withdraw (Last 3 Months)')]")
	   WebElement another1;
	   @FindBy(how=How.XPATH,using="//h4[contains(text(),'Deposit By Category (Last 3 Months)')]")
	   WebElement another2;
	   @FindBy(how=How.XPATH,using="//div[@class=\"page-title\"]//*[@class=\"active\"]")
	   WebElement welcomemsg;
	   
	
	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyhomepage() {
		
	System.out.println(homepageide.getText());
		return homepageide.getText();
	}
	
	public boolean smslogo() {
		
		return simage.isDisplayed();		
	}
	
	public boolean versiontext() {
		return version2.isDisplayed();	
	}
	
	public String dropdown() {	
		String droplist=null;
		for (int i = 0; i <allelements.size(); i++) {
		       droplist= allelements.get(i).getAttribute("nav-link");			
		}
		return droplist;
	}
	
	public String bargraphtitles() {
		
		String s1=accountstring.getText();
		String s2=another1.getText();
		String s3=another2.getText();
		return s1+" "+s2+" "+s3;
		
	}
	public  String Welcomename() {
		String welcome=welcomemsg.getText();
		return welcome;
		
	}
	
public String sidebartitle() {
	
	return sidetitle.getText();
	
}




	
	
}
