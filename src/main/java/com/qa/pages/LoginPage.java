package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.TestUtils;

public class LoginPage extends TestBase{
	
	//Page Factory
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement link_login;
	
	@FindBy(name="email")
	WebElement txt_userName;
	
	@FindBy(name="password")
	WebElement txt_password;

	@FindBy(xpath="//div[text()='Login']")
	WebElement btn_login;
	
	@FindBy(xpath="//div[@class='ui negative message']//p")
	WebElement inValidLoginMsg;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	private void clickLoginLink() {
		TestUtils.click(link_login);
		//link_login.click();
	}
	
	private void enterUserName(String uName) throws InterruptedException {
		TestUtils.enterText(txt_userName, uName);
		//Thread.sleep(5000);
		//txt_userName.sendKeys(uName);
	}
	
	private void enterPassword(String pass) {
		TestUtils.enterText(txt_password, pass);
		//txt_password.sendKeys(pass);
	}
	
	private void clickLoginBtn() {
		btn_login.click();
	}
	
	public String getInvalidMsgText() {
		return TestUtils.getTextOfElement(inValidLoginMsg);
	}
	
	public void login(String uName, String pass) throws InterruptedException {
		clickLoginLink();
		enterUserName(uName);
		enterPassword(pass);
		clickLoginBtn();
	}
}
