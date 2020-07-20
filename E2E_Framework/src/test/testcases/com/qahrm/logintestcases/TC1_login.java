package com.qahrm.logintestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.e2e.base.TestBase;
import com.orangehrm.dashboard.DashboardPage;
import com.orangehrm.login.LogingPage;

public class TC1_login extends TestBase {

	WebDriver driver;

	@Test(enabled = false)
	public void loginToApps() {
		driver = initializeDriver();
		LogingPage page = PageFactory.initElements(driver, LogingPage.class);
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		goToUrl();
		page.enterUsername("shridhara.jayaram");
		page.enterPassword("QaTest@1234*");
		page.clickLogin();
		boolean verifyDashboard = page.verifyDashboard();
		Assert.assertTrue(verifyDashboard);
		dashboardPage.clickLogout();

	}

	@Test(enabled = false)
	public void loginWithInvalidCredentials() {
		driver = initializeDriver();
		LogingPage page = PageFactory.initElements(driver, LogingPage.class);
		goToUrl();
		page.enterUsername("testuser");
		page.enterPassword("test@123");
		page.clickLogin();
		boolean verifyDashboard = page.VerifyInvalidMessage();
		Assert.assertTrue(verifyDashboard, "Invalid credentiual message is not displaying");
	}

	@Test
	public void verifyLoginMandatoryFieldErrorMessage() {
		driver = initializeDriver();
		LogingPage page = PageFactory.initElements(driver, LogingPage.class);
		goToUrl();

		// Step1: verify error message when user not enter both user name & password

		page.clickLogin();
		SoftAssert sref = new SoftAssert();
		sref.assertEquals(page.getMandatoryErrorMessage(), "Username cannot be empty123",
				"Expected Mandatory error message is not displaying");
		driver.navigate().refresh();

		// Step2: verify error message when user enter only user name

		page.enterUsername("test123");
		page.clickLogin();
		sref.assertEquals(page.getMandatoryErrorMessage(), "Password cannot be empty",
				"Expected Mandatory error message is not displaying");

		// Step3: verify error message when user enter only user name
		driver.navigate().refresh();
		page.enterPassword("test123");
		page.clickLogin();
		sref.assertEquals(page.getMandatoryErrorMessage(), "Username cannot be empty",
				"Expected Mandatory error message is not displaying");

		sref.assertAll();

	}
}
