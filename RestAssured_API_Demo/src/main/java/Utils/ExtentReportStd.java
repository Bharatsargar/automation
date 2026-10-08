package Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportStd implements ITestListener{
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext context) {
		
		sparkreporter=new ExtentSparkReporter(System.getProperty("user.dir")+"RestAssured_API_Demo/Reports/Report1.html");
		sparkreporter.config().setDocumentTitle("Automation Report");
		sparkreporter.config().setReportName("Functional Testing");
		sparkreporter.config().setTheme(Theme.DARK);
		
		extent =new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Computer Name", "Bharat Device");
		extent.setSystemInfo("Environment", "Dev");
		extent.setSystemInfo("Tester Name", "Bharat Sargar");
		extent.setSystemInfo("os", "Android");
		extent.setSystemInfo("App Name", "Novio");
		
	}
	public void onTestSuccess(ITestResult result) {
//	    System.out.println("Execute when test success...");
		test = extent.createTest(result.getName()); // create a new entry in report
		test.log(Status.PASS, "test case passed is: " +result.getName());		
	  }
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "test case failed is: " + result.getName());
		test.log(Status.FAIL, "test case failed cause is: "+ result.getThrowable());
		
	  }
	public void onTestSkipped(ITestResult result) {
	   test = extent.createTest(result.getName());
	   test.log(Status.SKIP, "test case skipped is: " + result.getName());
	  }
	
	public void onFinish(ITestContext context) {
	   extent.flush();
	  }

}
