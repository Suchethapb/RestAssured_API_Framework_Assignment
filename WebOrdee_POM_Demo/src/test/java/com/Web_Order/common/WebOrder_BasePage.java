package com.Web_Order.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Web_Order.home.WebOrders_SignInPage;

public class WebOrder_BasePage {
private WebDriver driver;
	
	//WebElement txtusername = driver.findElement(By.name(""));
	
	@FindBy(id = "ctl00_MainContent_username")
	WebElement txtUsername;

	@FindBy(id = "ctl00_MainContent_password")
	WebElement txtPassword;

	@FindBy(id = "ctl00_MainContent_login_button")
	WebElement btnLogin;
		
	@FindBy(linkText = "Logout")
	WebElement lnLogout;
	
	
	

	//public WebOrder_BasePage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	//}

	public WebOrder_BasePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

//	public void WebOrder_BasePage(WebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//	}

	// Sign in functionality
	public WebOrders_SignInPage GoToHomePageAndSignIn(String username, String passwd) throws Exception {
		return signInToWebOrders(username, passwd);
	}

	public WebOrders_SignInPage signInToWebOrders(String username, String passwd) {
		enterUserName(username);
		enterPassword(passwd);
		submitButton();
		return new WebOrders_SignInPage(driver);
	}

	public void enterUserName(String username) {
		txtUsername.clear();
		txtUsername.sendKeys(username);
	}

	public void enterPassword(String passwd) {
		txtPassword.clear();
		txtPassword.sendKeys(passwd);
	}

	public void submitButton() {
		btnLogin.click();
	}
	
	public void logout() throws InterruptedException {
		lnLogout.click();
		Thread.sleep(3000);
	
	}


}
