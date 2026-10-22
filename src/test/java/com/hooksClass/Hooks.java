package com.hooksClass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.driverFactory.DriverFactory;
import com.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	private static DriverFactory driverFactory;

	@Before(order = 0)
	public void loadConfig() {

		new ConfigReader().init_prop();

	}

	@Before(order = 1)
	public static void launchBrowser() {
		driverFactory = new DriverFactory();
		driverFactory.init_driver(ConfigReader.getProperty("browser"));
		driverFactory.getDriver().get(ConfigReader.getProperty("url"));

	}
	
	

	@After()
	public void tearDown(Scenario scenario) {
		WebDriver driver = driverFactory.getDriver();
		if (scenario.isFailed() && driver != null) {

			byte[] screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

			scenario.attach(screenshotAs, "image/png", "Failed Screenhot");

		}

		if (driver != null) {
			driver.quit();
			DriverFactory.unload();
		}

	}

}
