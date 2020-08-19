package com.orangehrm.pim;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.e3e.log4g.LoggerHelper;
import com.orangehrm.login.LogingPage;

/**
 * @author Shridhara
 *
 */
public class AddEmployee {
	private static final Logger log = LoggerHelper.getLogger(LogingPage.class);

	@FindBy(id = "firstName")
	private WebElement fname_t;

	@FindBy(id = "middleName")
	private WebElement mname_t;

	@FindBy(id = "lastName")
	private WebElement lname_t;

	@FindBy(id = "employeeId")
	private WebElement eid_t;

	@FindBy(id = "photofile")
	private WebElement pfield_b;

	@FindBy(id = "chkLogin")
	private WebElement clickLogin_cb;

	@FindBy(id = "btnSave")
	private WebElement save_b;

	@FindBy(id = "user_name")
	private WebElement uname_t;

	@FindBy(id = "user_password")
	private WebElement pword_t;

	@FindBy(id = "re_password")
	private WebElement cpword_t;

	@FindBy(id = "status")
	private WebElement status_dd;

	/**
	 * @param name
	 */
	public void enterFirstName(String name) {
		log.info("Entering firstname" + name);
		try {
			fname_t.sendKeys(name);

		} catch (Exception e) {
			log.error("Not able to enter firstname " + name);
			e.printStackTrace();
		}
	}

	/**
	 * @param name
	 */
	public void enterMiddleName(String name) {
		log.info("Entering MiddleName" + name);
		try {
			mname_t.sendKeys();

		} catch (Exception e) {
			log.error("Not able to enter MiddleName " + name);
			e.printStackTrace();
		}
	}

	/**
	 * @param name
	 */
	public void enterLastName(String name) {
		log.info("Entering LastName" + name);
		try {
			lname_t.sendKeys();

		} catch (Exception e) {
			log.error("Not able to enter LastName " + name);
			e.printStackTrace();
		}
	}

	/**
	 * @param name
	 */
	public void enterEmployeeID(String name) {
		log.info("Entering LastName" + name);
		try {
			eid_t.sendKeys();

		} catch (Exception e) {
			log.error("Not able to enter LastName " + name);
			e.printStackTrace();
		}
	}

	/**
	 * @param name
	 */
	public void chossePhotoGraph(String name) {
		log.info("Selecting select photo graph" + name);
		try {
			eid_t.sendKeys();

		} catch (Exception e) {
			log.error("Not able Selecting select photo graph " + name);
			e.printStackTrace();
		}
	}

	/**
	 * @param name
	 */
	public void createLoginCredential() {
		log.info(" clicking on createLoginCredential  ");
		try {
			clickLogin_cb.sendKeys();

		} catch (Exception e) {
			log.error("Not able to click on createLoginCredential ");
			e.printStackTrace();
		}
	}

	/**
	 * @param name
	 */
	public void clickOnSave() {
		log.info(" clicking on save button  ");
		try {
			save_b.sendKeys();

		} catch (Exception e) {
			log.error("Not able to click on save button ");
			e.printStackTrace();
		}
	}

	/**
	 * @param name
	 */
	public void enterUserName(String name) {
		log.info(" Entering Username "+name);
		try {
			uname_t.sendKeys(name);

		} catch (Exception e) {
			log.error("Not able to Entering Username "+ name);
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @param name
	 */
	public void enterPassword(String name) {
		log.info(" Entering password "+name);
		try {
			pword_t.sendKeys(name);

		} catch (Exception e) {
			log.error("Not able to Entering Password "+ name);
			e.printStackTrace();
		}
	}
	/**
	 * @param name
	 */
	public void enterConfirmPassword(String name) {
		log.info(" Entering ConfirmPassword "+name);
		try {
			cpword_t.sendKeys(name);

		} catch (Exception e) {
			log.error("Not able to Entering ConfirmPassword "+ name);
			e.printStackTrace();
		}
	}
	
	
	public void selectLoginStatus(String name) {
		log.info("Selecting log in status" + name);
		try {
			Select sref=new Select(status_dd);
			if(name.equalsIgnoreCase("Disabled"))
				sref.deselectByValue("Disabled");
			
		} catch (Exception e) {
			log.error("Not able to enter usenrman " + name);
			e.printStackTrace();
		}
	}
	
	
}
