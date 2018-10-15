package com.wallethub.qa.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wallethub.qa.base.BaseClass;
import com.wallethub.qa.pages.HomePage;
import com.wallethub.qa.pages.LoginPage;
import com.wallethub.qa.pages.ReviewPage;
import com.wallethub.qa.pages.TestInsuranceCompanyPage;
import com.wallethub.qa.pages.UserProfile;

public class PostingReviewCommentsTest extends BaseClass {

	public LoginPage oLoginPage;
	public HomePage oHomePage;
	public TestInsuranceCompanyPage oTestPage;
	public ReviewPage oReviewPage;
	public UserProfile oUsrProf;

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		initialize();
		oLoginPage = new LoginPage();
		oLoginPage.loginfromanyProfile();
		oHomePage = oLoginPage.LogintoApplication(oProp.getProperty("username"), oProp.getProperty("password"));
		if (oHomePage.checkCellPhoneDetails() == true)
			oHomePage.clickHomePageButton();

	}

	@Test
	public void testPostingReviewComment() throws InterruptedException {

		driver.get(oProp.getProperty("url"));
		oTestPage = new TestInsuranceCompanyPage();
		oReviewPage = oTestPage.hoveringOntotheRatingStars();
		oReviewPage.selectPolicyType(oProp.getProperty("policyType"));
		oReviewPage.clickOnStars();
		oReviewPage.enterReviewComments(oProp.getProperty("postMessage"));

	}

	@Test(enabled = false)
	public void verifyPostonUserProfile() {

		oUsrProf = oHomePage.openUserProfile();
		oUsrProf.clickOnReviews();
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
