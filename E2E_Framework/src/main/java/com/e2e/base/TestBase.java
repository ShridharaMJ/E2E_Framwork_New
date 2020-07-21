package com.e2e.base;

import java.io.File;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.e2e.javahelper.PropertieHelper;
import com.e3e.log4g.LoggerHelper;

public class TestBase {

	private static final Logger log = LoggerHelper.getLogger(TestBase.class);

	public PropertieHelper pref;
	public WebDriver driver;

	public TestBase() {
		pref = new PropertieHelper(".\\src\\main\\resource\\PropertiesFiles\\TestBase.properties");
	}

	public WebDriver initializeDriver() {

		String BROWSER_NAME = pref.getProperties("Browser");

		if (BROWSER_NAME.equalsIgnoreCase("chrome")) {
			System.setProperty(AutoConstant.CHROME_KEY, AutoConstant.CHROME_VALUE);
			driver = new ChromeDriver();
		} else if (BROWSER_NAME.equalsIgnoreCase("Firefox")) {
			System.setProperty(AutoConstant.FIREFOX_KEY, AutoConstant.FIREFOX_VALUE);
			driver = new FirefoxDriver();
		} else if (BROWSER_NAME.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		} else if (BROWSER_NAME.equalsIgnoreCase("Edge")) {
			// To-do
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;
	}

	/**
	 * <p>
	 * This method will open the URL provided in properties file.
	 * </p>
	 * 
	 * @see ./resource/propertiesFiles/TestBase
	 * @author Shridhara
	 */
	public void goToUrl() {
		String urlvalue = pref.getProperties("url");
		log.info("Entering URL: " + urlvalue);
		driver.get(urlvalue);

	}

	/**
	 * This function will goto URL provided in parameter
	 * 
	 * @param url
	 * @author Shridhara
	 */
	public void goToUrl(String url) {
		log.info("Entering URL: " + url);
		driver.get(url);
	}

	/**
	 * @param driver
	 * @param filename
	 * @author Shridhara
	 */
	public static void takeScreenShot(WebDriver driver, String filename) {
		String date = LocalDateTime.now().toString();
		TakesScreenshot shot = (TakesScreenshot) driver;
		File screenshotAs = shot.getScreenshotAs(OutputType.FILE);
		File destfolder = new File(System.getProperty("user.dir") + "\\TestReports\\Screenshots\\" + filename + date +".png");
		try {
			FileUtils.copyFile(screenshotAs, destfolder);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
@AfterMethod
public void tearDown() {
	
	log.info("Closing browse");
	driver.quit();
	
}
}
