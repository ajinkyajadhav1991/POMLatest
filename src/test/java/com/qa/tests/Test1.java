package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;

public class Test1 extends TestBase{
	
	LoginPage loginPage;
	
	@BeforeMethod
	public void initializePageClasses() {
		loginPage = new LoginPage();
	}
	
	@Test
	public void invalidLogin() throws InterruptedException {
		//loginPage = new LoginPage();
		loginPage.login("abc", "xyz");
		
		Assert.assertEquals(loginPage.getInvalidMsgText(), "Invalid login");
	}

}
