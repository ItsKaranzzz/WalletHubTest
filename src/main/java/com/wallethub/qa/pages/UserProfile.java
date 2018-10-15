package com.wallethub.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.qa.base.BaseClass;

public class UserProfile extends BaseClass {

	@FindBy(xpath = "//div[@class='profilenav']/descendant::li[3]")
	private WebElement profilereviews;

	public UserProfile() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnReviews() {
		profilereviews.click();
	}
}
