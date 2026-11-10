package com.driverFactory;

import java.util.Map;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

	public WebDriver init_driver(String browser) {
		System.out.println("Browser value is:" + browser);
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.setExperimentalOption("prefs",
					Map.of("credentials_enable_service", false, "profile.password_manager_enabled", false));
			tldriver.set(new ChromeDriver(options));
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
			tldriver.set(new SafariDriver());
		} else {
			System.out.println("please pass the correct browser value:" + browser);
		}
		getDriver().manage().window().setSize(new Dimension(1920, 1080));

		return getDriver();

	}

	public static WebDriver getDriver() {
		return tldriver.get();
	}

	public void configBrowser() {

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		 

	}

	public static void unload() {

		tldriver.remove();

	}

}
