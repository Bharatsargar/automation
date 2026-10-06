package com.novio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registrations {
	WebDriver driver;

	public Registrations(WebDriver driver) {
		
		driver = this.driver;
	}
	By GetStarted = By.xpath("//android.view.View[@content-desc=\"Get Started\"]");
	By EnterMobile = By.xpath("//android.widget.EditText:");
	By EnterName  = By.xpath("//android.view.View[@content-desc=\"Begin your journey!​\r\n"
			+ "Enter your mobile number to get started\r\n"
			+ "Mobile Number\r\n"
			+ "Please provide your full name\r\n"
			+ "Submit\"]/android.widget.EditText[2]");
	By checkbox1 = By.xpath("//*[contains(@content-desc,'Please provide your full name')]/android.widget.EditText[2]");
	By Submit = By.xpath("//android.view.View[@content-desc=\"Submit\"]");
	By OTPSubBtn = By.xpath("//android.view.View[@content-desc=\"Submit\"]");
	By EnterPan  = By.xpath("//android.widget.EditText");
	By ContinueBtn = By.xpath("//android.view.View[@content-desc=\"Continue\"]");
	
	public void get_started() {
		driver.findElement(GetStarted).click();
	}
	
	public void enter_mobile(String mobile) {
		driver.findElement(EnterMobile).click();
		driver.findElement(EnterMobile).sendKeys(mobile);
	}
	
	public void enter_name(String name) {
		driver.findElement(EnterName).click();
		driver.findElement(EnterName).sendKeys(name);
	}
	
	public void checkbox1() {
		driver.findElement(checkbox1).click();
	}
	
	public void submitmobile_and_name() {
		driver.findElement(Submit).click();
	}
	public void submit_otp() {
		driver.findElement(OTPSubBtn).click();
	}
	public void enterpan(String pan) {
		driver.findElement(EnterPan).click();
		driver.findElement(EnterPan).sendKeys(pan);
		}
	public void click_continue() {
		driver.findElement(ContinueBtn).click();
		
	}
		
	}
	
	
	

