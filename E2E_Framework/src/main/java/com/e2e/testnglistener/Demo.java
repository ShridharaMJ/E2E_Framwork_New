package com.e2e.testnglistener;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.e2e.base.TestBase;

public class Demo {
	TestBase base = new TestBase();

	@Test
	public void demoTest() {
		WebDriver driver = base.initializeDriver();
		base.goToUrl();
		boolean flag;
		if (5 > 4) {
			flag = true;
		}
		Assert.assertFalse(flag);
	}

}
