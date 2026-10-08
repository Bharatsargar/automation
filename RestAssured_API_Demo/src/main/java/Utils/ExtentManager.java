package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports createInstance(String fileName) {
		
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(fileName);
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setDocumentTitle("API Automation Report");
		htmlReport.config().setEncoding("utf-8");
		htmlReport.config().setReportName("API Test Report");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReport);
		
		return extent;
		
		
		
		
	}

}
