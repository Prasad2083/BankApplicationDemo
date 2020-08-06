package Reports;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManagerReports {
	
	//ExtentReports ----- Code reused for n number of test class to generate html reports
	//ExtentSparkReporter------ HTML Reports 
	//ExtentTest------ works to identify all the test classes and attach
	//reports for all the test cases in the test classes
	
	
	public static  ExtentReports extentreports;
	public static ExtentReports createInstance() {
	String filename= getReportName();
    String directory = System.getProperty("user.dir") +"/htmlreports/";
    new File(directory).mkdirs();
    
    String path = directory+filename;
    
    ExtentSparkReporter  htmlreport=new ExtentSparkReporter(path);
	
    htmlreport.config().setEncoding("utf-8");
	 htmlreport.config().setDocumentTitle("Extent Automation Results");
	 htmlreport.config().setReportName("Automation Results");
	 htmlreport.config().setTheme(Theme.STANDARD);
	 extentreports= new ExtentReports();
	 
	    extentreports.setSystemInfo("TestNGReport", "Results");
		extentreports.setSystemInfo("Browser", "Chrome");
		extentreports.attachReporter(htmlreport);
		return extentreports;
	}

public static String getReportName() {
    Date d= new Date();
	String filename="AutomationReport"+d.toString().replace(":", "_").replace(" " , "_")+".html";
	
	return filename;
}


}
