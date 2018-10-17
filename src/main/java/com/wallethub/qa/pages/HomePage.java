package com.wallethub.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wallethub.qa.base.BaseClass;

public class HomePage extends BaseClass {
	public WebDriverWait oWait;

	@FindBy(xpath = "//h2[contains(text(),'Thank you for registering with WalletHub!')]")
	private WebElement logginSuccessText;

	@FindBy(className = "txt")
	private WebElement homepagebtn;

	@FindBy(xpath = "//a[@class='user']")
	private WebElement userLink;

	@FindBy(xpath = "//a[contains(text(),'Profile')]")
	private WebElement userProfile;

	@FindBy(xpath = "//h2[text()='Last 4 Of Your SSN']")
	private WebElement cellDetails;

	public HomePage() {
		PageFactory.initElements(driver, this);
		oWait = new WebDriverWait(driver, 200);
	}

	public boolean verifyForLoginSuccess() {
		return logginSuccessText.isDisplayed();
	}

	public void clickHomePageButton() {

		homepagebtn.click();

	}

	public boolean checkCellPhoneDetails() {
		oWait.until(ExpectedConditions.elementToBeClickable(cellDetails));
		if (cellDetails.isDisplayed())
			return true;
		else
			return false;
	}

	public UserProfile openUserProfile() {
		Actions a = new Actions(driver);
		oWait.until(ExpectedConditions.elementToBeClickable(userLink));
		a.moveToElement(userLink).build().perform();
		a.moveToElement(userProfile).click().perform();

		return new UserProfile();
	}

}
