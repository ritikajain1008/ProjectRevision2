package com.revision.hooks;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.revision.factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends DriverFactory{

	@Before
	public void BeforeExecution() {
		InitializeWebDriver();
		openBrowser();
	}

	@After(order = 1)
	public void takeScreenshotOnFailure(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}

	@After(order = 0)
	public void tearDown() {
		driver.close();
		System.out.println("This is called after scenario");
	}

}
