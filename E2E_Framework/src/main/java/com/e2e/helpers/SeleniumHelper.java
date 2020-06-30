package com.e2e.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumHelper {
	WebDriver driver;

	public By byValue(String locator) {
		String[] strsplit = locator.split(":");
		String locatortype = strsplit[0];
		String locatorvalue = strsplit[1];

		switch (locatortype.toLowerCase()) {
		case "xpath":
			return By.xpath(locatorvalue);
		case "id":
			return By.id(locatorvalue);
		case "classname":
			return By.className(locatorvalue);
		case "tagname":
			return By.tagName(locatorvalue);
		case "name":
			return By.name(locatorvalue);
		case "cssselector":
			return By.cssSelector(locatorvalue);
		case "linkedtesx":
			return By.linkText(locatorvalue);
		case "partialLinkText":
			return By.partialLinkText(locatorvalue);

		default:
			return null;
		}

	}

	public WebElement getWebElement(String bylocator) {
		return driver.findElement(byValue(bylocator));
	}

	public void clickOnElement(String str) {
		getWebElement(str).click();
	}

	public void sendValue(String locatorname, String sendingdata) {
		getWebElement(locatorname).sendKeys(sendingdata);
	}

}
