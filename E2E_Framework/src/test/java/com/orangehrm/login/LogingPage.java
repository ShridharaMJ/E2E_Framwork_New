package com.orangehrm.login;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.e2e.base.E2eexception;
import com.e3e.log4g.LoggerHelper;

/**
 * @author Shridhara
 *
 */
public class LogingPage {

	private static final Logger log = LoggerHelper.getLogger(LogingPage.class);
	WebDriver driver;
	@FindBy(id = "txtUsername")
	public WebElement uname;
	@FindBy(id = "txtPassword")
	public WebElement pwrod;
	@FindBy(id = "btnLogin")
	public WebElement loginbutton;
	@FindBy(id = "menu_dashboard_index")
	public WebElement dashboard;
	@FindBy(xpath = "//*[text()='Invalid credentials']")
	public WebElement invalidmsgele;
	@FindBy(xpath = "//span[@id='spanMessage']")
	public WebElement merror;

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

	/**
	 * @param pvalue
	 * @author Shridhara
	 */
	public void enterPassword(String pvalue) {
		log.info("Entering password" + pvalue);
		try {
			pwrod.sendKeys(pvalue);
		} catch (Exception e) {
			log.error("Not able to enter password " + pvalue);
			e.printStackTrace();
		}
	}

	/**
	 * @author Shridhara
	 * 
	 */
	public void clickLogin() {
		log.info("Clicking on Login");
		try {
			loginbutton.click();
		} catch (Exception e) {
			log.error("Not able to click on login");
			e.printStackTrace();
		}
	}

	/**
	 * @return
	 * @author Shridhara
	 */
	public boolean verifyDashboard() {
		log.info("Veifying Dasboard page");
		return dashboard.isDisplayed();
	}

	/**
	 * @return
	 * @author Shridhara
	 */
	public boolean VerifyInvalidMessage() {
		log.info("Verifing invalid message");
		return invalidmsgele.isDisplayed();

	}

	/**
	 * @return String
	 * @author Shridhara
	 */
	public String getMandatoryErrorMessage() {

		String text = merror.getText();
		log.info("Error message is : " + text);
		return text;

	}

	public void loginToApp(String username,String password) throws E2eexception {
		
		try {
			log.info("Entering username "+username);
			uname.sendKeys(username);
			log.info("Entering Password "+password);
			pwrod.sendKeys(password);
			log.info("Clicking on log-in");;
			clickLogin();
		}
		catch (Exception e) {
			log.error("Not able to loginto applaication");
			throw new E2eexception("Not able to login to application "+e);
		}
		
	}

}
