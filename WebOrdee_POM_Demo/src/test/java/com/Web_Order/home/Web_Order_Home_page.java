package com.Web_Order.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Web_Order_Home_page {
	WebDriver driver;

	public Web_Order_Home_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "View all orders")
	WebElement allOrdersTab;

	@FindBy(linkText = "View all products")
	WebElement allProductsTab;
	
	@FindBy(linkText = "Order")
	WebElement orderTab;
	
	
	public WebOrders_ViewAllOrdersPage clickOnAllOrdersTab() {
		allOrdersTab.click();
		return new WebOrders_ViewAllOrdersPage(driver);
	}
	
	public WebOrders_ViewAllProductsPage clickOnAllProductsTab() {
		allProductsTab.click();
		return new WebOrders_ViewAllProductsPage(driver);
	}
	public WebOrders_OrdersPage clickOnOrdersTab() {
		orderTab.click();
		return new WebOrders_OrdersPage(driver);
	}

}
