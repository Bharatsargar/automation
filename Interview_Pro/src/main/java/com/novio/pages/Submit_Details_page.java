package com.novio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.novio.action.ActionDriver;

public class Submit_Details_page {
	
	private ActionDriver actiondriver;
	
	private By phone = By.xpath("(//*[contains(@class, 'bg-half-surface')])[1]");
	private By name = By.xpath("(//*[contains(@class, 'bg-half-surface')])[2]");
	private By pin = By.xpath("(//*[contains(@class, 'bg-half-surface')])[3]");
	private By check1 = By.xpath("//input[@id=\"v-0-4\"]");
	private By submit1 = By.xpath("//button[@type=\"submit\"]");
	
	// Initialize the ActionDriver object by passing the WebDriver instance.
	public Submit_Details_page(WebDriver driver) {
		this.actiondriver = new ActionDriver(driver);
			
	}
	
	public void submit_details() {
		//actiondriver.p
		
	}
	
	
	

}
