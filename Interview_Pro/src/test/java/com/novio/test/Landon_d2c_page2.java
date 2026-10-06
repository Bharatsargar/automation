package com.novio.test;

import org.testng.annotations.Test;

import com.novio.base.BaseClass;

public class Landon_d2c_page2 extends BaseClass {

	@Test
	public void land_d2c_noviopage() {
		
		String title = driver.getTitle();
		System.out.println(title);
		assert title.equals("Get Best Credit Card Offers!") : "Test Failed - Title is not matching...";
		
	}
	
	
}
