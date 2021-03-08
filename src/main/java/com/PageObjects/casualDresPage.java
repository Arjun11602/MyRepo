package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class casualDresPage extends BasePage {

	public casualDresPage(WebDriver driver) {
		super(driver);
		
	}
	
	private By addToCart=By.xpath("//span[text()='Add to cart']");
	private By pricTag=By.xpath("//span[@class='price product-price']//parent::div[@itemprop='offers']//preceding-sibling::p");
	private By proceedToCheckOut=By.xpath("//a[@title='Proceed to checkout']");
	

	public void addToCart() throws InterruptedException {
		WebElement ele=getWebElement(addToCart);
		System.out.println(ele.getText());
		scrollToView(ele);
		wait.until(ExpectedConditions.elementToBeClickable(ele));	
		buttonClickUsingJS(ele);
		
	}
	
	public OrderPage proceedToCheckOut() throws InterruptedException {
		
		addToCart();
		Thread.sleep(3000);
		windowHandles();
		buttonClick(proceedToCheckOut);
		return new OrderPage(driver);
		
		
		
	}
	
	public String priceTagcheck() {
		
		String text=getPageHeader(pricTag);
		System.out.println("price Value is "+text);
		return text;
	}
}
