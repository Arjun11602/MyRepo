package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public Page(WebDriver driver) {
		
		this.driver=driver;
		this.wait=new WebDriverWait(this.driver,30);
		
	}
	
	public abstract String getPageTitle();
	public abstract String getPageHeader(By locator);
	public abstract WebElement getWebElement(By locator);
	public abstract void waitForElementPresent(By locator);
	public abstract void waitForPageTitle(String title);
	public abstract void sendKeysToTextBox(By locator, String string);
	public abstract void buttonClick(By locator);
	public abstract void windowHandles();
	public abstract void mouseActions(By locator);
	
	
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		//TPage obj=null;
		try {
		 return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
			//return obj;
		}
		catch(Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	

}
