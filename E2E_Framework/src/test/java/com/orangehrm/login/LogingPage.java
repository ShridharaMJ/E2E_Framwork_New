package com.orangehrm.login;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.e3e.log4g.LoggerHelper;

public class LogingPage {
	
	private static final Logger log = LoggerHelper.getLogger(LogingPage.class);
	WebDriver driver;

	
//************** Start Of Method******************** 

	@FindBy(id = "txtUsername")
	private WebElement uname;

	/**
	 * This method used to enter username in username field
	 * 
	 * @param name
	 * @author Shridhara
	 */
	public void enterUsername(String name) {
		log.info("Entering username" + name);
		try {
			uname.sendKeys(name);

		} catch (Exception e) {
			log.error("Not able to enter usenrman " + name);
			e.printStackTrace();
		}
	}

//************** End Of Method******************** 

//************** Start Of Method******************** 

	@FindBy(id = "txtPassword")
	private WebElement pwrod;

	public void enterPassword(String pvalue) {
		log.info("Entering password" + pvalue);
		try {
			pwrod.sendKeys(pvalue);
		} catch (Exception e) {
			log.error("Not able to enter password " + pvalue);
			e.printStackTrace();
		}
	}

// ************** End Of Method********************

//************** Start Of Method******************** 

	@FindBy(id = "btnLogin")
	private WebElement loginbutton;

	public void clickLogin() {
		log.info("Clicking on Login");
		try {
			loginbutton.click();
		} catch (Exception e) {
			log.error("Not able to click on login");
			e.printStackTrace();
		}
	}

// ************** End Of Method********************

	@FindBy(id="menu_dashboard_index")
	private WebElement dashboard;
	
	public boolean verifyDashboard() {
		return dashboard.isDisplayed();
	}
}
