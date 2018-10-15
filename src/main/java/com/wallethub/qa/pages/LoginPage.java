package com.wallethub.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.qa.base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(xpath = "//a[contains(text(),'Login')]/parent::li")
	private WebElement LoginSection;

	@FindBy(xpath = "//input[@type='text' and @name='em']")
	private WebElement username;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;

	@FindBy(xpath = "//span[contains(text(),'Login')]")
	private WebElement loginSubmitButton;

	@FindBy(xpath = "//a[contains(text(),'Login')]")
	private WebElement LoginbuttonFromanyProfile;

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	public void loginfromanyProfile() {
		LoginbuttonFromanyProfile.click();

	}

	public void loginfromLoginPage() {
		LoginSection.click();
	}

	public HomePage LogintoApplication(String uname, String pwd) {

		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginSubmitButton.click();

		return new HomePage();
	}
}
