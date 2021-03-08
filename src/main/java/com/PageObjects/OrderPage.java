package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage {

	public OrderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By proccedToCheckout=By.xpath("//a[@title='Proceed to checkout']");
	

	
	public void proccedToCheckoutOrder() {
		
		buttonClick(proccedToCheckout);
	}
}
