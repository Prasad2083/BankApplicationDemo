package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ViewCheckingPage;
import com.qa.testbase.TestBaseClass;

public class ViewCheckingPageTest extends TestBaseClass {
	
	LoginPage loginpage;
	HomePage homepg;
	ViewCheckingPage viewchpage;

	public ViewCheckingPageTest() throws IOException {
		super();	
		
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		intializationoftasks();
		loginpage=new LoginPage();
		homepg=loginpage.checkingexcel(prop.getProperty("username"), prop.getProperty("password"));
		viewchpage=new ViewCheckingPage();
	}
	
	
	/*@Test(priority = 1)
	
	public void pageview() throws IOException{
		
		viewchpage.viewcheckpage();
		
	}*/
	
	
	@Test(priority = 1)
	public void checkview() {
	String icon=viewchpage.icon1();
	Assert.assertEquals(icon, "First_Deploy");
		
	}
	
	@Test(priority = 2)
	public void toogle() {
		viewchpage.toggleclick1();
	}
	
	//@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
	
	

}
