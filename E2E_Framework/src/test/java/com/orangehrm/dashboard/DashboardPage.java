package com.orangehrm.dashboard;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.e2e.base.E2eexception;
import com.e3e.log4g.LoggerHelper;
import com.orangehrm.login.LogingPage;

public class DashboardPage {
	private static final Logger log = LoggerHelper.getLogger(LogingPage.class);
	WebDriver driver;

	@FindBy(xpath = "//div[@id='mainMenu']//li//a[@class='firstLevelMenu']")
	public List<WebElement> menu_items;

	@FindBy(xpath = "//a[@id='welcome']")
	public WebElement welcomeddele;
	@FindBy(xpath = "//div[@id='welcome-menu']//a[text()='Logout']")
	public WebElement logoutele;
	@FindBy(xpath = "//div[@id='dashboard-quick-launch-panel-container']/..//*[text()='Quick Launch']")
	public WebElement quickLauchele;
	@FindBy(xpath = "//table[@class='quickLaungeContainer']//span[@class='quickLinkText']")
	public List<WebElement> quickLauchmenunames;

	public void clickLogout() {
		log.info("Clicking on Welcome dropdown");
		welcomeddele.click();
		log.info("clicking on Logout");
		logoutele.click();

	}

	/**
	 * This function will click on menu based on Arg Ex- ClickMenu("Admin") It will
	 * click Admin menu
	 * 
	 * @param MenuName
	 * @author Shridhara
	 * @date 21 July 2020
	 * 
	 * 
	 * 
	 **/
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

	/**
	 * @author Shridhara
	 * @date 21 July 2020
	 * @return
	 * @throws E2eexception
	 */
	public List<String> listOfMenu() throws E2eexception {
		List<String> menu_names = new ArrayList<String>();
		try {
			List<WebElement> listofitems = menu_items;
			for (WebElement webElement : listofitems) {
				String text = webElement.getText();
				menu_names.add(text);
				log.info("Menu names : " + text);
			}
		} catch (Exception e) {
			throw new E2eexception("Not able to fetch menu " + e);
		}
		return menu_names;

	}

	/**
	 * @author Shridhara
	 * @date 21 July 2020
	 * @param menuname
	 * @throws E2eexception
	 */
	public void clickOnQuickLauchMenu(String menuname) throws E2eexception {

		try {
			quickLauchmenunames.stream().filter(a -> a.getText().equalsIgnoreCase(menuname))
					.collect(Collectors.toList()).get(0).click();
			;
		} catch (Exception e) {
			throw new E2eexception("Not able to click on menu " + menuname + " " + e);
		}

	}

	public List<String> listOfQuickMenuItems() throws E2eexception {
		List<String> collect = null;
		try {
			collect = quickLauchmenunames.stream().map(a -> a.getText()).collect(Collectors.toList());
		} catch (Exception e) {
			throw new E2eexception("Not able to get on menu" + e);
		}

		return collect;

	}

}
