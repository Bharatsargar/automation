package com.novio.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	protected static Properties prop;
	protected static WebDriver driver;

	@BeforeSuite
	public void loadConfig() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
		prop.load(fis);
	}

	// Initialize the webdriver based on browser defined in config properties
	private void launchBrowser() {
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		} else {
			throw new IllegalArgumentException("Browser not supported : " + browser);
		}
	}

	// Configure browser setting
	private void configureBrowser() {
		// implicitwait applied
		int implicitwait = Integer.parseInt(prop.getProperty("implicitwait"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitwait));

		// maximize the browser
		driver.manage().window().maximize();
		try {
			driver.get(prop.getProperty("URL1"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to nevigate to the URL:" + e.getMessage());

		}

	}

	@BeforeMethod
	public void setup() throws IOException {

		System.out.println("Setting up WebDriver for :" + this.getClass().getSimpleName());
		launchBrowser();
		configureBrowser();
		staticwait(2);

	}

	@AfterMethod
	public void teardown() {

		if (driver != null) {
			try {
				driver.quit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Unable to quit the driver:  " + e.getMessage());
			}
		}

	}

	public void staticwait(int seconds) {
		LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(seconds));
	}
	
	//Driver getter method
	public WebDriver getDriver(){
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	///public void getProp
	
}
