package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.LoginPage;
import com.qa.pages.SignUpPage;
import com.qa.testbase.TestBaseClass;
import com.qa.testutils.ExcelPractice;

public class SignUpPageTest extends TestBaseClass {

	public SignUpPageTest() throws IOException {
		super();
		
	}
	LoginPage loginpage;
	SignUpPage signup;
	String sheetname="SignUp";
	
	@BeforeMethod
	public void setup() throws IOException {
		//Parent class method to initialize the general tasks
		intializationoftasks();
		loginpage=new LoginPage();
		signup=loginpage.tosignup();	
	}
	
	
	
public Object[][] storedatainprovider(String Excelname, String testsheetname) throws IOException {
		
	      ExcelPractice datalogin=new ExcelPractice(System.getProperty("user.dir")+"/src/main/java/com/qa/testdata/Data_Driven_Practice.xlsx");
		
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


@DataProvider
public Object[][] signupdata() throws IOException{
	
	Object[][] data=storedatainprovider("Data_Driven_Practice.xlsx", sheetname);
	
	System.out.println("Print Data from excel"+data);
	return data;
	
	
}

@Test(dataProvider = "signupdata")
public void completeregistration(String Title,String FirstName,String LastName,String Gender,String DOB, String Email,String SSN,String Password, String ConfrimPassword,String Address, String Locality,String Region, String PSCode, String Country, String MobilePhone) throws IOException {
	
	
	signup.selectvaluesfordropdown(Title);
	
	if(Gender.equals("f")) {
		signup.fmale();
		
	}
	else {
		signup.male();
		
	}
	
	signup.Signupdetails(FirstName, LastName, DOB, Email, SSN, Password, ConfrimPassword, Address, Locality, Region, PSCode, Country, MobilePhone);

}


	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
	

}
