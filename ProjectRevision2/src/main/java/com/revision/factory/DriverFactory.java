package com.revision.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	public static WebDriver driver;
	static File log_file = new File("./log4j.properties"); // log file path
	static File file = new File("./src/test/resources/config.properties"); // config prop file path
	static FileInputStream log_fis = null;
	static FileInputStream fis = null;
	public static Properties prop = new Properties();
	static {
		try {
			fis = new FileInputStream(file);
			log_fis = new FileInputStream(log_file);
			PropertyConfigurator.configure(log_fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fis);
			prop.load(log_fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void InitializeWebDriver() {
		if (prop.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe"); // for Chrome browser
			driver = new ChromeDriver();
		} else if (prop.getProperty("Browser").equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe"); // for firefox browser
			driver = new FirefoxDriver();

		} else if (prop.getProperty("Browser").equalsIgnoreCase("Microsoft Edge")) {
			System.setProperty("webdriver.edge.driver", ".\\Drivers\\msedgedriver.exe"); // for MicrosoftEdge browser
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit Wait

	}

	public static void openBrowser() {
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

}
