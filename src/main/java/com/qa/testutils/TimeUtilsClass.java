package com.qa.testutils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.testbase.TestBaseClass;

public class TimeUtilsClass extends TestBaseClass{
	
	
	//Here in this wherever we are declaring timeouts we can declare explicitly 
	//here so that we can modify easily whenever we require
	
	public TimeUtilsClass() throws IOException {
		super();
		
	}
	public static long IMPLICIT_TIME_OUT=15;
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrfile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File("./target/screenshots/screen.jpg"));
		driver.close();
		
	}
		
	

}
