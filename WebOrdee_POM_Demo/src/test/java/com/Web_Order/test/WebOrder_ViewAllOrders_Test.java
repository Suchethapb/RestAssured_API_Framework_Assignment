package com.Web_Order.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Web_Order.common.WebOrder_BasePage;
import com.Web_Order.common.WebOrder_BaseSetup;
import com.Web_Order.home.WebOrders_EditOrderPage;
import com.Web_Order.home.WebOrders_SignInPage;
import com.Web_Order.home.WebOrders_ViewAllOrdersPage;
import com.Web_Order.home.Web_Order_Home_page;
import com.Web_Order.utilities.WebOrders_TestData;

public class WebOrder_ViewAllOrders_Test extends WebOrder_BaseSetup{
	WebOrders_SignInPage signIn;
	Web_Order_Home_page homePage;
	WebOrder_BasePage basePage;
	WebOrders_ViewAllOrdersPage viewAllOrderPage;
	WebOrders_EditOrderPage editOrdersPage;
	private WebDriver driver;

	private String name = "Charles Dodgeson";
	private String product = "MyMoney";

	@BeforeClass
	public void setUp() {
		driver = getDriver();
		basePage = new WebOrder_BasePage(driver);
	}

	@Test(description = "Validate check all button", priority = 1, enabled = true)
	public void verifyCheckAll() throws Exception {
		test = extent.createTest("Test Case 1", "Verify if all orders are seleted if Check All button is clicked");
		signIn = basePage.GoToHomePageAndSignIn("Tester", "test");
		signIn.verifySignInPageText();
		homePage = new Web_Order_Home_page(driver);
		viewAllOrderPage = homePage.clickOnAllOrdersTab();
		viewAllOrderPage.clickCheckAll();
		Assert.assertEquals(true, viewAllOrderPage.verifyAllOrdersSelected(), "All records are not selected.");
	}

	@Test(description = "Validate uncheck all button", priority = 2, enabled = true)
	public void verifyUnCheckAll() throws Exception {
		test = extent.createTest("Test Case 2", "Verify if all orders are unselected if UnCheck All button is clicked");

		viewAllOrderPage.clickUncheckAll();
		Assert.assertEquals(true, viewAllOrderPage.verifyAllOrdersUnselected(), "Records are still selected.");
	}

	@Test(description = "Validate user can delete an order", priority = 3, enabled = true)
	public void verifyDeleteOrder() throws Exception {
		test = extent.createTest("Test Case 3", "Verify if user can delete an order");

		viewAllOrderPage.deleteOrder(name, product);
		Assert.assertEquals(true, viewAllOrderPage.verifyDeletedRecord(name), "Records are still Exists.");
	}

	@Test(description = "Validate user can edit an order", dataProvider = "Update Form", dataProviderClass = WebOrders_TestData.class, priority = 4, enabled = true)

	public void verifyEditOrder(String product, String qty, String custName, String street, String city, String state,
			String zip, String card, String cardNr, String expiry, String expectedResult) throws Exception {

		editOrdersPage = viewAllOrderPage.clickEdit();

		editOrdersPage.updateFieldSuccess(product, qty, custName, street, city, state, zip, card, cardNr, expiry);
		viewAllOrderPage = new WebOrders_ViewAllOrdersPage(driver);

		viewAllOrderPage.verifyUpdatedOrder(product, qty, custName, street, city, state, zip, card, cardNr, expiry);

	}

	@Test(description = "Validate error is displayed while editing an order with invalid Data", dataProvider = "Update Order Form Error", dataProviderClass = WebOrders_TestData.class, priority = 5, enabled = true)

	public void verifyError(String product, String qty, String custName, String street, String city, String state,
			String zip, String card, String cardNr, String expiry, String expectedResult) throws Exception {

		editOrdersPage = viewAllOrderPage.clickEdit();

		editOrdersPage.validateError(product, qty, custName, street, city, state, zip, card, cardNr, expiry,
				expectedResult);
		homePage = new Web_Order_Home_page(driver);
		homePage.clickOnAllOrdersTab();
		viewAllOrderPage = new WebOrders_ViewAllOrdersPage(driver);

	}

}
