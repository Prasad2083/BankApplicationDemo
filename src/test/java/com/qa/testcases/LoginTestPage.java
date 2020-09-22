package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.CheckingPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.SignUpPage;
import com.qa.testbase.TestBaseClass;
import com.qa.testutils.ExcelPractice;
import com.qa.testutils.TimeUtilsClass;

public class LoginTestPage extends TestBaseClass {
	
	
	//A constructor is required here because we have use the properties where we already declared some tasks data
   //This setup initialize all the declared things in different places so that directly these cases will execute 
	//super() keyword is used to get the initialized properties in the parent class....Here Parent class TestBaseClass!!! 
	public LoginTestPage() throws IOException {
		super();
		
	}

	LoginPage loginpage;
	HomePage homepg;
	SignUpPage signup;
	String sheetname1="Login";
	String sheetname="InvalidLogin";
	String error;
	String colName;
	
	@BeforeMethod
	public void setup() throws IOException {
		//Parent class method to initialize the general tasks
		intializationoftasks();
		loginpage=new LoginPage();
		homepg=new HomePage();
	}
	
	//Adding annotations with priorities execute the test cases in a expected sequential order
	@Test(priority = 1)
	public void titlevalidate() {
		
		String pagetitle=loginpage.gettitleofthepage();
		//Assertions are used to validate the test data(actual vs expected)
		Assert.assertEquals(pagetitle, "Digital Bank");
		
	}
	@Test(priority = 2)
	public void signuppage() throws IOException {
		signup=loginpage.tosignup();
	}
	
	// A method is created to get the data from the excel file and the return type 
	//of this method is Object(Where it can store any kind of data,Object[][])

	public Object[][] storedatainprovider(String Excelname, String testsheetname) throws IOException {
		
		ExcelPractice datalogin= new ExcelPractice(System.getProperty("user.dir")+"/src/main/java/com/qa/testdata/Data_Driven_Practice.xlsx");
		
		int rowcount=datalogin.getrowcount(sheetname);
		int colcount=datalogin.getColumnCount(sheetname);
		
		Object dataexcel[][]=new Object[rowcount-1][colcount];
		
		for (int i = 2; i <= rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				
				dataexcel[i-2][j]=datalogin.getCellData(sheetname, j, i);
				
			}
			
		}
		return dataexcel;	
	}
	
	//above used method is used here to execute the test scripts by providing the annotation data provider
	
	@DataProvider
	public Object[][] logindata() throws IOException{
		
		Object[][] data=storedatainprovider("Data_Driven_Practice.xlsx", sheetname);
		return data;
		
	}
	
	//Now test cases are executed taking the data from excel
	
	@Test(priority=3,dataProvider = "logindata")
	
	public void completelogin(String UserName,String Password) throws IOException {
       
		String msg=loginpage.checkingloginpage(UserName, Password);
	
		
		Assert.assertEquals(msg, "Error");
		
		//loginpage.checkingexcel(UserName, Password);
				
	}
	
	
	//@Test(priority = 4)
	
	public void ValidLogin() throws IOException {
		loginpage.checkingexcel(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
