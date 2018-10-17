package com.wallethub.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wallethub.qa.base.BaseClass;

public class Utils extends BaseClass {

	public static final String CONFIG_FILE_PATH = "C:\\\\Users\\\\kxc212\\\\Downloads\\\\WalletHubTest-master\\\\src\\\\main\\\\java\\\\com\\\\wallethub\\\\qa\\\\config\\\\configurations.properties";

	public static Properties propertyReader() throws IOException {

		oProp = new Properties();

		FileInputStream fpropReader = new FileInputStream(new File(CONFIG_FILE_PATH));
		oProp.load(fpropReader);

		return oProp;
	}

	public static void hoveringToStars(List<WebElement> inputSet, WebDriverWait oWait) throws InterruptedException {
		Actions action = new Actions(driver);
		for (WebElement e : inputSet) {
			oWait.until(ExpectedConditions.elementToBeClickable(e));
			action.moveToElement(e).build().perform();

			if (e.getText().equals("5"))
				action.moveToElement(e).click().perform();

		}
	}
}
