package StepDefinitions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.novio.pages.Registrations;

import Utils.ExcelDataProvider;


public class RegistrationsSteps {
	public static AndroidDriver driver;
	
	public static AndroidDriver getDriver() {
		return driver;
	}
	
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
	
	
	
	@Given("Reset Mobile and PAN in credilio")
	public void resetMobileAndPANInCredilio() {
	   System.out.println("Strated mobile and pan reseting in CREDILIO data.....");
	   
	   Response response = given().baseUri("https://d13-api.credilio.info/")
			   .header("content-type","application/json")
			   .header("x-api-key","EBXqqIKgwKfzgeHAogp2XgVckuSFb6TL")
			   .body("{\n    \"mobile\": [ 9999988888 ],\n    \"pan\": [ \"AAAPA1298F\"],\n    \"reset_bureau_report\": true\n}")
			   .when()
			   .post("data-reset/customer")
			   .then()
			   .extract().response();
	   
	   System.out.println("Status code : "+ response.getStatusCode());
	   System.out.println("Data reset successfully on credilio portal....");
			   
	}
	@Given("Reset mobile and PAN in novio")
	public void resetMobileAndPANInNovio() {
		System.out.println("Strated mobile and pan reseting in NOVIO data.....");
	
		
		Response response = given().baseUri("https://d13-api.novio.co.in/")
				.header("content-type","application/json")
				.header("x-api-key", "EBXqqIKgwKfzgeHAogp2XgVckuSFb6TL")
				.body("{\n    \"mobile\": [ 9999988888 ],\n    \"pan\": [ \"AAAPA1298F\"],\n    \"reset_bureau_report\": true\n}")
				.when()
				.post("data-reset/v1/customer")
				.then()
				.extract().response();
		System.out.println("Status code :"+ response.statusCode());
		System.out.println("Data reset successfully on novio portal....");
	   
	   
	}
	@Then("Launch the novio app")
	public void launchTheNovioApp() throws Exception {
		System.out.println("Starting app launching....");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:platformVersion", "14");
		caps.setCapability("appium:deviceName", "Samsung Galaxy M13");
		caps.setCapability("appium:app", "C:\\Users\\Bharat-Sargar\\eclipse-workspace\\Novio_Master\\App\\d13 novio.apk");
		caps.setCapability("appium:automationName", "UiAutomator2");
		
		try {
			driver =new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	   System.out.println("App launch successfully....");
	}
	
	@When("Accept the app permission and click Get Started")
	public void acceptTheAppPermissionAndClickGetStarted() throws Exception {
	   System.out.println("Accept the permission.... ");
	   Thread.sleep(4000);
//	   driver.switchTo().alert().accept();
//	   Thread.sleep(2000);
//	   driver.switchTo().alert().accept();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//android.view.View[@content-desc=\"Get Started\"]")).click();
	  
	   
	   	      
	}
	@When("Enter mobile and name")
	public void enterMobileAndName() throws Exception {
		System.out.println("Enter mobile and name....");
		   Thread.sleep(2000);
	   driver.findElement(By.xpath("//android.widget.EditText")).click();
	   driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("9999988888");
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//android.widget.CheckBox")).click();
	   System.out.println("Printing the boolean value of the webelement is there or not??");
	   driver.findElement(By.xpath("//android.view.View[starts-with(@content-desc, 'Begin your journey')]//android.widget.EditText[2]\r\n"
	   		+ "")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//android.view.View[starts-with(@content-desc, 'Begin your journey')]//android.widget.EditText[2]\r\n"
	   		+ "")).sendKeys("Bharat R Sargar");
	   Thread.sleep(2000);
	   driver.hideKeyboard();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//android.view.View[@content-desc=\"Submit\"]")).click();
	   Thread.sleep(2000);

	}
	@When("Autofill OTP")
	public void autofillOTP() throws Exception {
		   Thread.sleep(2000);

		   driver.findElement(By.xpath("//android.view.View[@content-desc=\"Submit\"]")).click();

	}
	@Then("Enter PAN")
	public void enterPAN() throws Exception {
		Thread.sleep(2000);
	   driver.findElement(By.xpath("//android.widget.EditText")).click();
		Thread.sleep(2000);

	   driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("AAAPA1298F");
		Thread.sleep(2000);
		driver.hideKeyboard();
	}
	@Then("Change the Name")
	public void changeTheName() {
	   
	   
	}
	@Then("continue and land on homescreen")
	public void continueAndLandOnHomescreen() throws Exception {
	   Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Continue\"]")).click();
		   Thread.sleep(4000);
		driver.switchTo().alert().accept();

	}
	

	
	
	
	

}
