package com.Web_Order.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Web_Order.common.WebOrder_BasePage;
import com.Web_Order.common.WebOrder_BaseSetup;
import com.Web_Order.home.WebOrders_SignInPage;
import com.Web_Order.home.Web_Order_Home_page;

public class WebOrder_Login extends WebOrder_BaseSetup{
	WebOrders_SignInPage signIn;
	Web_Order_Home_page homePage;
	WebOrder_BasePage basePage;
	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
		basePage = new WebOrder_BasePage(driver);
	}

	@Test(description = "Login and validate the WebOrder Homepage Text", priority = 1)
	public void loginTest() throws Exception {
		test = extent.createTest("Test Case 1", "Verify Text after login");
		signIn = basePage.GoToHomePageAndSignIn("Tester", "test");
		Thread.sleep(3000);
		signIn.verifySignInPageText();
		basePage.logout();
	}

	@Test(description = "validateURL() method call for URL verification", priority = 2)
	public void urlTest() throws Exception {
		test = extent.createTest("Test Case 2", "Verify URL after login");
		signIn = basePage.GoToHomePageAndSignIn("Tester", "test");
		Thread.sleep(3000);
		signIn.verifySignInPageURL();
		basePage.logout();
	}

	@Test(description = "validateURL() method call for URL verification", priority = 3)
	public void verifyText() throws Exception {
		test = extent.createTest("Test Case 3", "Verify Text after login");
		signIn = basePage.GoToHomePageAndSignIn("Tester", "test");
		Thread.sleep(3000);
		signIn.verifySignInPageText();
		basePage.logout();
	}
}


