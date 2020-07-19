package com.orangehrm.dashboard;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.e3e.log4g.LoggerHelper;
import com.orangehrm.login.LogingPage;

public class DashboardPage {
	private static final Logger log = LoggerHelper.getLogger(LogingPage.class);
	WebDriver driver;

	@FindBy(xpath = "//div[@id='mainMenu']//li//a[@class='firstLevelMenu']")
	private List<WebElement> menu_items;

	@FindBy(xpath = "//a[@id='welcome']")
	private WebElement welcomeddele;
	@FindBy(xpath = "//div[@id='welcome-menu']//a[text()='Logout']")
	private WebElement logoutele;

	public void clickLogout() {
		log.info("Clicking on Welcome dropdown");
		welcomeddele.click();
		log.info("clicking on Logout");
		logoutele.click();

	}

	public void ClickMenu(String MenuName) {

		List<WebElement> listofitems = menu_items;
		for (WebElement webElement : listofitems) {
			String text = webElement.getText();
			log.info("Menu name is :" + text);
			if (text.equalsIgnoreCase(MenuName)) {
				webElement.click();
				log.info("Clickling on Menu " + text);
			}
		}
	}

}
