package com.PageObjects;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);

	}

	@Override
	public String getPageTitle() {
		String title=driver.getTitle();
		return title;
	}

	@Override
	public String getPageHeader(By locator) {
		waitForElementPresent(locator);
		String text=getWebElement(locator).getText();
		return text;
	}

	@Override
	public WebElement getWebElement(By locator) {
		WebElement element=null;
		try {
			element=driver.findElement(locator);
			return element;
		}
		catch(Exception e) {
			e.printStackTrace();
			return element;

		}

	}

	@Override
	public void waitForElementPresent(By locator) {

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}


	@Override
	public void buttonClick(By locator) {
		waitForElementPresent(locator);
		getWebElement(locator).click();

	}

	@Override
	public void windowHandles() {
		String childwindow=driver.getWindowHandle();
		driver.switchTo().window(childwindow);
	}

	@Override
	public void mouseActions(By locator) {
		Actions action =new Actions(driver);
		waitForElementPresent(locator);
		action.moveToElement(getWebElement(locator)).build().perform();

	}

	@Override
	public void waitForPageTitle(String title) {
		wait.until(ExpectedConditions.titleContains(title));

	}

	@Override
	public void sendKeysToTextBox(By locator, String string) {
		waitForElementPresent(locator);
		WebElement ele=getWebElement(locator);
		ele.clear();
		ele.sendKeys(string);

	}

	public void buttonClickUsingJS(WebElement element) {

		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);	
	}
	public void scrollToView(WebElement element) {

		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);	
	}
	
	public static void TakeScreenShot() throws IOException {
		
		TakesScreenshot screen=((TakesScreenshot) driver);
		File img=screen.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(img, new File(System.getProperty("user.dir"),"//ScreenShots//img.png"));
		
	}
}
