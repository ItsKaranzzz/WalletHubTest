package com.wallethub.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wallethub.qa.base.BaseClass;

public class ReviewPage extends BaseClass {
	public WebDriverWait oWait;

	@FindBy(xpath = "//span[contains(text(),'Please select your policy')]")
	private WebElement policyTypeDropdown;

	@FindBy(xpath = "//textarea[@name='review']")
	private WebElement reviewComments;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitComments;

	public ReviewPage() {

		PageFactory.initElements(driver, this);
		oWait = new WebDriverWait(driver, 50);
	}

	public void selectPolicyType(String policyType) {

		policyTypeDropdown.click();
		driver.findElement(By.xpath("//a[@data-target='" + policyType + "']/parent::li")).click();
	}

	public void enterReviewComments(String comments) {
		reviewComments.clear();
		reviewComments.sendKeys(comments);
		submitComments.click();
	}

	public void clickOnStars() {

		List<WebElement> stars = driver.findElements(By.xpath("//span[@id='overallRating']/a"));

		for (WebElement e : stars) {

			oWait.until(ExpectedConditions.elementToBeClickable(e));
			e.click();

		}

	}
}
