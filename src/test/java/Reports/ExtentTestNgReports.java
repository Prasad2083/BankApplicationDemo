package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.testbase.TestBaseClass;
import java.io.IOException;



public class ExtentTestNgReports extends TestBaseClass{
	public ExtentTestNgReports() throws IOException {
		super();
		
	}


	public ExtentSparkReporter htmlreport;
	public ExtentReports extentreports;
	public ExtentTest extenttest;
	

 public void beforeClass() throws IOException {
	 
	 htmlreport=new ExtentSparkReporter("./test-output/extent.html");
	 htmlreport.config().setEncoding("utf-8");
	 htmlreport.config().setDocumentTitle("Extent Automation Results");
	 htmlreport.config().setReportName("Automation Results");
	 htmlreport.config().setTheme(Theme.STANDARD);
	 
	 extentreports= new ExtentReports();
	 
	extentreports.setSystemInfo("TestNGReport", "Results");
	extentreports.setSystemInfo("Browser", "Chrome");
	extentreports.attachReporter(htmlreport);
	intializationoftasks();
	}
	
  

}
