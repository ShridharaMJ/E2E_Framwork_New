package com.qahrm.dashboardtestcases;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.e2e.base.E2eexception;
import com.e2e.base.TestBase;
import com.e3e.log4g.LoggerHelper;
import com.orangehrm.dashboard.DashboardPage;
import com.orangehrm.login.LogingPage;

public class TC2_Dashboardverification extends TestBase {
	private static final Logger log = LoggerHelper.getLogger(TC2_Dashboardverification.class);
	WebDriver driver;

	@Test
	public void DB21012324() throws E2eexception {
		driver = initializeDriver();
		goToUrl();

		List<String> expectedMenunames = Arrays.asList("Admin", "PIM", "Leave", "Time", "Recruitment", "Dashboard",
				"Directory", "Maintenance", "Buzz");
		List<String> expectedQuickmenunames = Arrays.asList("Assign Leave", "Leave List", "Timesheets", "Apply Leave",
				"My Leave", "My Timesheet");
		LogingPage logingPage = PageFactory.initElements(driver, LogingPage.class);
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		logingPage.loginToApp("shridhara.jayaram", "QaTest@1234*");

		// Step1: Verifying dashboard upon clicking on login
		logingPage.verifyDashboard();

		// Step2: Verifying main menu names
		List<String> listOfMenu = dashboardPage.listOfMenu();
		for (String string : expectedMenunames) {
			if (listOfMenu.contains(string)) {
				log.info(string + " is dislaying");
			} else {
				log.error(string + " is not present in UI");
				throw new E2eexception(string + " is not present in UI");
			}
		}

		// Ste3: verifying quickLauch
		log.info("Verifing Dashboard defaukt menu");
		Assert.assertTrue(dashboardPage.quickLauchele.isDisplayed(), "Quick Lauch is not diaplying");

		// Step3: verifying Quick Menu

		List<String> listOfQuickMenuItems = dashboardPage.listOfQuickMenuItems();

		for (String string : expectedQuickmenunames) {
			if (listOfQuickMenuItems.contains(string)) {
				log.info(string + " is dislaying");
			} else {
				log.error(string + " is not present in UI");
				throw new E2eexception(string + " is not present in UI");
			}
		}
		//TestBase.takeScreenShot(driver, "Dashboard_HomePage");
	}

	
}
