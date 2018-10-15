package com.wallethub.qa.base;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.wallethub.qa.utilities.Utils;

public class BaseClass {

	public static WebDriver driver;
	public static ChromeOptions options;
	public static Properties oProp;

	public static void initialize() throws IOException {
		oProp = Utils.propertyReader();

		if (oProp.getProperty("browser").equalsIgnoreCase("chrome")) {
			options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", oProp.getProperty("sourceFolderLoc")
					+ "\\main\\java\\com\\wallethub\\qa\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.navigate().to(oProp.getProperty("url"));
		} else if (oProp.getProperty("browser").equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", oProp.getProperty("sourceFolderLoc")
					+ "\\\\main\\\\java\\\\com\\\\wallethub\\\\qa\\\\drivers\\\\ieexplorer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(oProp.getProperty("url"));
		} else if (oProp.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.ie.driver", oProp.getProperty("sourceFolderLoc")
					+ "\\\\main\\\\java\\\\com\\\\wallethub\\\\qa\\\\drivers\\\\\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(oProp.getProperty("url"));
		}
	}

}
