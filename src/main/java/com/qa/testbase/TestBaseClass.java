package com.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.qa.testutils.TimeUtilsClass;
import com.qa.testutils.WebdriverEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass {
	
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver event_driver;
	public static WebdriverEventListener eventlistener;
	
	//Here the constructor is initializing the properties file,
	//where we are storing all the repeated tasks like url,browsername etc..
	
	public TestBaseClass() throws IOException  {
		prop =new Properties();
		FileInputStream stream=null;
        stream=new FileInputStream("C:/Users/varaprasad/Documents/eclipse-workspace/CRMProject/src/main/java/com/qa/config/config.properties");
		
		prop.load(stream);	
		
	}
	
	//Create  method which stores all the values from properties file and any other values from other pages
	
	public static void intializationoftasks() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		event_driver=new EventFiringWebDriver(driver);
		eventlistener=new WebdriverEventListener();
		event_driver.register(eventlistener);
		driver=event_driver;
		//TimeUtils is class where we declare our timeouts of the project
		driver.manage().timeouts().implicitlyWait(TimeUtilsClass.IMPLICIT_TIME_OUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	
	

}
