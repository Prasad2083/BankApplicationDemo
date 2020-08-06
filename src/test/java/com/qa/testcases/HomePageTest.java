package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.testbase.TestBaseClass;
import com.qa.testutils.ExcelPractice;

public class HomePageTest extends TestBaseClass {
	
	LoginPage loginpage;
	HomePage homepg;
	String sheetname="Login";
	public HomePageTest() throws IOException {
		super();
			
	}
	
public Object[][] storedatainprovider(String Excelname, String testsheetname) throws IOException {
		
		ExcelPractice datalogin=new ExcelPractice("C:\\Users\\varaprasad\\Documents\\eclipse-workspace"
				+ "\\CRMProject\\src\\main\\java\\com\\qa\\testdata\\Data_Driven_Practice.xlsx");
		
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
public Object[][] welcomedata() throws IOException{
	
	Object[][] data=storedatainprovider("Data_Driven_Practice.xlsx", sheetname);
	return data;
	
}


@Test(dataProvider = "welcomedata")
public void welcomeverify(String UserName,String Password, String FirstName) throws IOException {
	
	if(UserName!=""|Password!="")
	{
		intializationoftasks();
		loginpage=new LoginPage();
		homepg=loginpage.checkingexcel(UserName,Password);
		String msg1=homepg.Welcomename();
		System.out.println(msg1);
		System.out.println(FirstName);
		if(msg1.equals(FirstName)) {
		Assert.assertEquals(msg1, FirstName);
		driver.quit();
		}
		else {
			System.out.println("Not Matched thrown error");
		}
	}
	
	
	else
		{
		driver.quit();
		}
}

	@BeforeMethod
	   public void setup() throws IOException {
		intializationoftasks();
		loginpage=new LoginPage();
		homepg=loginpage.checkingexcel(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	
	@Test(priority = 1)
	public void verifylogo() {
		boolean flag=homepg.smslogo();
		System.out.println(flag);
		
	}
	
	@Test(priority = 2)
	public void versionverify() {	
		boolean flag=homepg.versiontext();
		System.out.println(flag);
		
	}
	@Test(priority = 3)
	public void dropverify() {
		String savelist=homepg.dropdown();
		System.out.println(savelist);
		
	}
	
	@Test(priority = 4)
	public void verifysidetitle() {
		String sidetitle=homepg.sidebartitle();
		System.out.println(sidetitle);
	}
	
	@Test(priority = 5)
	public void verifybank() {
		String titles=homepg.bargraphtitles();
		System.out.println("Print all titles :"+titles);
		Assert.assertEquals(titles, "Account Balance Summary Deposit vs. Withdraw (Last 3 Months) Deposit By Category (Last 3 Months)");
	
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}

}
