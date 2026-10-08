package webtestreport;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestReprort {
	public static WebDriver driver;
	
	@BeforeTest
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://d13-customer.credilio.in/");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				
	}
	@Test(priority =1)
	public void Test_01() {
		boolean status = driver.findElement(By.xpath("//div[@class='min-h-72 md:min-h-80']/div")).isDisplayed();
		Assert.assertEquals(status, true);
	}
	@Test(priority = 2)
	public void Test_02() {
		WebElement element=driver.findElement(By.xpath("djkjd"));
		element.click();
		
	}
	@Test(priority =3, dependsOnMethods = {"Test_02"})
	public void Test_03() {
		System.out.println("this test should skipp");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
