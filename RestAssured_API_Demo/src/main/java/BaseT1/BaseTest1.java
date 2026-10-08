package BaseT1;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utils.ConfigReader;
import Utils.ExtentManager;
import io.restassured.RestAssured;
import io.restassured.internal.http.Status;


public class BaseTest1 {
		
		protected static ExtentReports extent;
		protected static ExtentTest test;
		
		@BeforeSuite
		public void setupReport() {
			
			System.out.println("inside beforeSuite");
		extent =	ExtentManager.createInstance("Test Report ExtentReport");
			
			
		}
	
	
	
	
		@BeforeClass
		public void setupAPI() {
			System.out.println("inside beforeClass");
			
		RestAssured.baseURI = ConfigReader.getProperties("baseURI");
		System.out.println("Base URI set to: "+ RestAssured.baseURI);
		
	}
		@BeforeMethod
	    public void startTest(ITestResult result) {
	        test = extent.createTest(result.getMethod().getMethodName());
	    }
		
		@AfterMethod
		public void logTestResults(ITestResult result) {
			//test = extent.createTest(result.getMethod().getMethodName());
			System.out.println("inside beforeMethod");
			if(result.getStatus() == ITestResult.SUCCESS) {
				
			test.log(com.aventstack.extentreports.Status.PASS	, result.getMethod().getMethodName() + " passed");
			}else if(result.getStatus() == ITestResult.FAILURE) {
			test.log(com.aventstack.extentreports.Status.FAIL, result.getMethod().getMethodName() + "failed" + result.getThrowable());
			}else if(result.getStatus()	 == ITestResult.SKIP) {
			test.log(com.aventstack.extentreports.Status.SKIP, result.getMethod().getMethodName() + "skipped");
			
			
			}					
		}
		
		
		@AfterSuite
		public void teardownReport() {
			
			System.out.println("inside afterSuite");
			extent.flush();
			
		}
	
	

}
