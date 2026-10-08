package BaseT1;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {
	
	public void onStart(ITestContext context) {
	    System.out.println("Executes when test start");
	  }
	
	public void onTestStart(ITestResult result) {
	   System.out.println("Test each and everyone started.....");
	  }
	
	public void onTestSuccess(ITestResult result) {
	    System.out.println("Execute when test success...");
	  }
	
	public void onTestFailure(ITestResult result) {
	    System.out.println("Exceute when test fails...");
	  }
	
	public void onTestSkipped(ITestResult result) {
	    System.out.println("Excute on test skipped....");
	  }
	public void onFinish(ITestContext context) {
	    System.out.println("Execute on test finish...");
	  }
	

}
