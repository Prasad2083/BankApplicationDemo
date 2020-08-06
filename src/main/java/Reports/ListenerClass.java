package Reports;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qa.testbase.TestBaseClass;

public class ListenerClass extends TestBaseClass implements ITestListener {
	
	public ListenerClass() throws IOException {
		super();
		
	}

	private static ExtentReports extent= ExtentManagerReports.createInstance();
	private static ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		
		ExtentTest test = extent.createTest(result.getTestClass().getName()+ "::"+ result.getMethod().getMethodName());
		extenttest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		
		String logtext="<b>Test Method "+result.getMethod().getMethodName() +"Successful</b>";
		Markup mark= MarkupHelper.createLabel(logtext, ExtentColor.GREEN);
		extenttest.get().log(Status.PASS, mark);
	}

	public void onTestFailure(ITestResult result) {
		String exceptionMsg=Arrays.toString(result.getThrowable().getStackTrace());
		extenttest.get().fail("<details><summary><b><font color=red>"+"Exception Occured, "
				+ "click to see details :"+"</font></b></summary>"+exceptionMsg.replaceAll(",", "<br>")+ "</details>\n");
		try {
			intializationoftasks();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		String path= takeScreenshot(driver,result.getMethod().getMethodName());
		try {
			
			extenttest.get().fail("<b><font color=red>"+ "Screenshot of failed Testcase"+"</font></b>",
					MediaEntityBuilder.createScreenCaptureFromPath(path).build() );
		
		}catch (Exception e) {
			
			extenttest.get().fail("Test failed Cannot attach screenshot");
			
		}
		
		String logtext="<b>Test Method "+result.getMethod().getMethodName() +"Failure</b>";
		Markup mark= MarkupHelper.createLabel(logtext, ExtentColor.RED);
		extenttest.get().log(Status.FAIL, mark);
		
	}

	public void onTestSkipped(ITestResult result) {
		
		String logtext="<b>Test Method "+result.getMethod().getMethodName() +"Skipped</b>";
		Markup mark= MarkupHelper.createLabel(logtext, ExtentColor.YELLOW);
		extenttest.get().log(Status.SKIP, mark);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
		if(extent != null) {
			extent.flush();
		}
		
	}
	
	
	public String takeScreenshot(WebDriver driver,String methodName) {
		
		String filename= getScreenshotName(methodName);
		String directory= System.getProperty("user.dir")+"/screenshots/";
		new File(directory).mkdirs();
		String path=directory+filename;
		
		try {
			File scrfile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrfile, new File(path));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return path;
		
	}

	private String getScreenshotName(String methodName) {
		
		Date d= new Date();
		String filename="AutomationReport"+d.toString().replace(":", "_").replace(" " , "_")+".png";
		
		
		
		return filename;
	}

}
