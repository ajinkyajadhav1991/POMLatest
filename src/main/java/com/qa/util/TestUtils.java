package com.qa.util;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class TestUtils extends TestBase{
	
	static String mainWindow;
	
	public static void enterText(WebElement element, String txt) {
		
		element = wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(txt);
	}
	
	public static void click(WebElement element) {
		element = wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public static String getTextOfElement(WebElement element) {
		
		element = wait.until(ExpectedConditions.visibilityOf(element));
		
		return element.getText();

	}
	
	public static void switchToNewWindow() {
		
		mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		
		Iterator<String> iterator = allWindows.iterator();
		
		while(iterator.hasNext()) {
			String childWindow = iterator.next();
			
			if(!mainWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
			}
		}
		
	}
	
	public static void switchToMainWindow() {
		driver.switchTo().window(mainWindow);
	}
	
	
	

}
