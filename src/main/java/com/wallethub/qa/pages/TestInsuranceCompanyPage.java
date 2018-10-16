package com.wallethub.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wallethub.qa.base.BaseClass;

public class TestInsuranceCompanyPage extends BaseClass {

	public WebDriverWait wait;
	@FindBy(xpath = "//span[@class='wh-rating rating_4_5']")
	private WebElement ratingStars;

	public TestInsuranceCompanyPage() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 200);
	}

	public ReviewPage hoveringOntotheRatingStars() throws InterruptedException {

		// ratingStars.click();
		Actions action = new Actions(driver);

		action.moveToElement(ratingStars).build().perform();
		/*
		 * action.moveToElement( driver.findElement(By.
		 * xpath("//div[@class='wh-rating-choices' and @style='display: none;']"))).
		 * build() .perform();
		 */

		List<WebElement> stars = driver.findElements(By.xpath(
				"//span[@class='wh-rating rating_4_5']/following-sibling::div[@class='wh-rating-choices']/descendant::a"));

		Utils.hoveringToStars(stars, wait);

		return new ReviewPage();

	}
}
