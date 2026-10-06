package StepDefinitions;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import BaseAPI.SetAPI;
import Utils.ConfigDataProvider;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class Novio_Onboarding extends SetAPI {
	public static AndroidDriver driver;
	public static ConfigDataProvider datapr;
	public void dataprovider1() throws Exception {
		datapr=new ConfigDataProvider();
		
	}
	

	@Given("User launch the app")
	public void user_launch_the_app() throws Exception {
		datapr=new ConfigDataProvider();
		System.out.println("base URI = "+ datapr.apiBaseUrlCredilio());
		System.out.println("Executing Post reset User API Test...");
		
		Response response= given().baseUri(datapr.apiBaseUrlCredilio())
				.header("Content-Type", "application/json")
				.header("x-api-key", "EBXqqIKgwKfzgeHAogp2XgVckuSFb6TL")
				.body("{\n    \"mobile\": [\n         9999988888\n        \n           ],\n    \"pan\": [\n        \"HDVPP5678Y\"           \n    ],\n    \"aadhaar\": [\n        \"842520730730\"\n    ],\n    \"email\": [\n        \"noviosbm77@gmail.com\",\n        \"depp10uee@gmail.com\",\n        \"prajjwal@spense.money\",\n        \"debojyotisingha452@gmail.com\",\n        \"noviobharat5@gmail.com\",        \n        \"jampani.credilio@gmail.com\",\n        \"sbmlogintest@gmail.com\",\n        \"bharatsargar24@gmail.com\",\n        \"Jampani007@credilio.in\",\n        \"crediliotest@gmail.com\",\n        \"noviosbmtest@gmail.com\",\n        \"noviobrand71@gmail.com\",\n        \"Jani007@credilio.in\",\n        \"rpal730@gmail.com\",\n        \"yuvraj@credilio.in\",\n        \"yuvrajsonawane1@gmail.com\"\n    ],\n    \"reset_bureau_report\": true\n}\n")
				.when()
				.post("data-reset/v1/customer")
				.then()
				.extract().response();
		
		System.out.println("API status code" + response.getStatusCode());
		Thread.sleep(3000);
		System.out.println("Calling post API for Store Bureau...");
				
		
		System.out.println("Inside the app launch");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		

		// Required capabilities
		capabilities.setCapability("platformName", "Android");  // The platform you're testing on
		capabilities.setCapability("appium:platformVersion", "14");   // Android version
		capabilities.setCapability("appium:deviceName", "Samsung Galaxy M13");   // The name of the device or emulator
		capabilities.setCapability("appium:app", "C:\\Users\\Bharat-Sargar\\eclipse-workspace\\Novio_Master\\App\\d13 novio.apk"); // Path to your APK file
		//capabilities.setCapability("appPackage", "com.novio.customer.d13"); // The package name of the app
		//capabilities.setCapability("appActivity", "com.novio.customer.MainActivity"); // The main activity of the app
		capabilities.setCapability("appium:automationName", "UiAutomator2"); // Automation framework (UiAutomator2 is widely used)
		//capabilities.setCapability("noReset", true); // If you don’t want to reset app data on launch
		//capabilities.setCapability("fullContextList", true); // Get full context list for hybrid apps (optional)
		//capabilities.setCapability("udid", "RZ8W20F9N3K");
		
		try {
			driver=new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("user enter mobile number and name")
	public void user_enter_mobile_number_and_name() throws Exception {
		System.out.println("inside the mobile & name enter");
		
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Get Started\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.EditText")).click();
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("9999988888");
		driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'Please provide your full name')]/android.widget.EditText[2]")).click();
		driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'Please provide your full name')]/android.widget.EditText[2]")).sendKeys("Automation Test");
		Thread.sleep(2000);
		driver.hideKeyboard();
//		Actions actions = new Actions(driver);
//        actions.moveByOffset(600, 1100).click().perform();
		
		driver.findElement(By.xpath("//android.widget.CheckBox")).click();

		Thread.sleep(2000);


	}

	@When("clicks on submit button")
	public void clicks_on_submit_button() {
		
		System.out.println("btn submit");
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Submit\"]")).click();

	}

	@When("Submit the OTP")
	public void submit_the_OTP() throws Exception {
		
		System.out.println("otp submit");
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Submit\"]")).click();
		Thread.sleep(5000);
		
		
	}

	@When("submit the pan number")
	public void submit_the_pan_number() {
		System.out.println("Enter pan number");

	}

	@Then("user is navigating to novio homepage")
	public void user_is_navigating_to_novio_homepage() {
		System.out.println("homepage landing");

	}
	
	

	public static void main(String[] args) throws Exception {
		Novio_Onboarding on=new Novio_Onboarding();
		on.user_launch_the_app();
		
	}

}
