package com.novio.action;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionDriver {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public ActionDriver(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	//wait for the webelement click
	public void waitForElementToBeClikable(By by) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Element is not clickable due ot: "+ e.getMessage());
		}
	}
	public void waitForElementToBeVisible(By by) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Element is not visible :"+e.getMessage());
		}
	}

	public void click(By by) {
		try {
			driver.findElement(by).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Element is not clickable: "+e.getMessage());
		}
	}
	
	public boolean isDisplayed(By by) {
		try {
			waitForElementToBeVisible(by);
			boolean isDisplayed = driver.findElement(by).isDisplayed();
			if(isDisplayed) {
				System.out.println("Element is Visible");
			}else {
				return isDisplayed;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Element is not visible : "+ e.getMessage());
		}
		return false;
	}
	
	// scroll the method by using javascript
	public void scrollToElement(By by) {
		try {
			JavascriptExecutor js= (JavascriptExecutor) driver;
			WebElement element = driver.findElement(by);
			js.executeScript("argumnet[0],scrollIntoView(true);", element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to locate element : "+ e.getMessage());
		}
	}
	
	public void waitForPageLoad(int timeOutInSec) {
		
		try {
			wait.withTimeout(Duration.ofSeconds(timeOutInSec)).until(WebDriver -> ((JavascriptExecutor) WebDriver).executeScript("return document.readyState").equals("complete"));
		System.out.println("Page load successfully..");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Page did not load within - "+ timeOutInSec+ "Seconds "+ e.getMessage());
		}
				
	}
	public void enterText(By by, String value) {
		try {
			waitForElementToBeVisible(by);
			WebElement element = driver.findElement(by);
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to enter the value : "+ e.getMessage());
		}
	}
	
}
