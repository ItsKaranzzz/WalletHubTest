package com.wallethub.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.wallethub.qa.base.BaseClass;

public class Utils extends BaseClass {

	public static Properties propertyReader() throws IOException {

		oProp = new Properties();

		FileInputStream fpropReader = new FileInputStream(new File(
				"C:\\Users\\DV6\\eclipse-workspace\\WalletHubTest\\src\\main\\java\\com\\wallethub\\qa\\config\\configurations.properties"));
		oProp.load(fpropReader);

		return oProp;
	}
}
