package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	
	}

	private By userNameText=By.xpath("//span[text()='Midhun Krishna')]");
	private By dressLink=By.xpath("//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]");
	private By casualDress=By.xpath("//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]");
	//private By casualDress=By.linkText("Casual Dresses");
	private By casualDresstext=By.xpath("//span[@class='cat-name']");
	


	public casualDresPage selectCasualDress() {
		mouseActions(dressLink);
		WebElement ele=getWebElement(casualDress);
		buttonClickUsingJS(ele);
		return new casualDresPage(driver);
}
	
	public String casualDressPageTitle() {
		waitForPageTitle("Casual Dresses - My Store");
		String title=getPageTitle();
		return title;
		
	}
	
	public String casualDresstextCheck() {
		
		String text=getPageHeader(casualDresstext);
		return text;
		
		
	}
}