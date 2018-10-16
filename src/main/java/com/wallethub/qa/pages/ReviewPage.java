package com.wallethub.qa.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wallethub.qa.base.BaseClass;
import com.wallethub.qa.utilities.Utils;

public class ReviewPage extends BaseClass {
	public WebDriverWait oWait;

	@FindBy(xpath = "//span[contains(text(),'Please select your policy')]")
	private WebElement policyTypeDropdown;

	@FindBy(xpath = "//textarea[@name='review']")
	private WebElement reviewComments;

	@FindBy(xpath = "//input[@type='submit' and @value='Submit']")
	private WebElement submitComments;

	@FindBy(xpath = "//h1[text()='Awesome!']")
	private WebElement postCommentStatusCheck;

	@FindBy(xpath = "//span[contains(text(),'5')]/parent::a")
	private WebElement lastStar;

	public ReviewPage() {

		PageFactory.initElements(driver, this);
		oWait = new WebDriverWait(driver, 50);
	}

	public void selectPolicyType(String policyType) {

		policyTypeDropdown.click();
		driver.findElement(By.xpath("//a[@data-target='" + policyType + "']/parent::li")).click();
	}

	public void enterReviewComments(String comments) throws InterruptedException {
		reviewComments.clear();
		reviewComments.sendKeys(comments);

	}

	public void clickonSubmit() throws InterruptedException {
		oWait.until(ExpectedConditions.elementToBeClickable(submitComments));
		submitComments.click();

		Thread.sleep(2000);
	}

	public void clickOnStars() throws InterruptedException {

		List<WebElement> stars = driver.findElements(By.xpath("//span[@id='overallRating']/a"));

		Utils.hoveringToStars(stars, oWait);

		lastStar.click();

	}

	public boolean checkthePostedCommentSentorNot() {

		oWait.until(ExpectedConditions.elementToBeClickable(postCommentStatusCheck));
		return postCommentStatusCheck.isDisplayed();
	}

	public void handleAlert() {

		Alert a = driver.switchTo().alert();
		a.accept();
	}
}
