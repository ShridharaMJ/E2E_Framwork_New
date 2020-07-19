package com.e2e.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.e3e.log4g.LoggerHelper;

public class AutomationUtile {
	private static final Logger log = LoggerHelper.getLogger(AutomationUtile.class);

	public WebDriver driver;
	TestBase base;

	public AutomationUtile() {
		base = new TestBase();
		this.driver = base.initializeDriver();
	}

	@BeforeMethod
	public void SetUp() {
		log.info("Initial set up is started");

		base.goToUrl();

	}

	@AfterMethod
	public void teardown() {
		log.info("Closing browse");
		driver.quit();
	}

}
