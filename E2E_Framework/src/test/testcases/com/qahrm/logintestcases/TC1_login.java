package com.qahrm.logintestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.e2e.base.TestBase;
import com.orangehrm.login.LogingPage;

public class TC1_login extends TestBase {

	WebDriver driver;

	@Test
	public void loginToApps() {
		driver = initializeDriver();
		LogingPage page = PageFactory.initElements(driver, LogingPage.class);

		goToUrl();
		page.enterUsername("shridhara.jayaram");
		page.enterPassword("QaTest@1234*");
		page.clickLogin();

		boolean verifyDashboard = page.verifyDashboard();
		Assert.assertTrue(verifyDashboard);

		driver.quit();
	}
}
