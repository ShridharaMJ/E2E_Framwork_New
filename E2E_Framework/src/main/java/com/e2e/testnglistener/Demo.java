package com.e2e.testnglistener;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.e2e.base.AutomationUtile;
import com.e2e.base.TestBase;

public class Demo extends AutomationUtile {
	
	
	WebDriver driver;
	public Demo() {
		driver=super.driver;
	}
	
	@Test
	public void demoTest() {
		
		System.out.println(driver.getTitle());
		boolean flag;
		TestBase.takeScreenShot(driver, "TestingScreenShot");
		if (5 > 4) {
			flag = true;
		}
		Assert.assertFalse(flag);
	}
	@Test
	public void demoTest2() {
	
		System.out.println(driver.getTitle());
		boolean flag;
		TestBase.takeScreenShot(driver, "TestingScreenShot");
		if (5 > 4) {
			flag = false;
		}
		Assert.assertFalse(flag);
	}

}
