package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.CheckingPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ViewCheckingPage;
import com.qa.testbase.TestBaseClass;

public class CheckingPageTest extends TestBaseClass {
	
	LoginPage loginpage;
	HomePage homepg;
	CheckingPage checkpage;
	public CheckingPageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		intializationoftasks();
		loginpage=new LoginPage();
		homepg=loginpage.checkingexcel(prop.getProperty("username"), prop.getProperty("password"));
		checkpage=new CheckingPage();
	}
	
	@Test(priority = 1)
	public void checknewlinkpage() {
		String linkpage=checkpage.NCA();
		Assert.assertEquals(linkpage, "New Checking Account");
	}
	
	
	@Test(priority = 2)
	public void creatingaccount1() {
		checkpage.Standardcheck();
		
	}
	
	@Test(priority = 3)
	public void creatingaccount2() {
		checkpage.InterestCheck();
	}
	
	@Test(priority = 4)
	public void resetaccount() {
		checkpage.Reset();
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	

}
