package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends BasePage{

	public LogInPage(WebDriver driver) {
		super(driver);

	}

	private By signIn=By.xpath("//a[@class='login']");
	private By emailId=By.id("email");
	private By passWord=By.id("passwd");
	private By submit=By.id("SubmitLogin");

	public void sigInClick() {

		buttonClick(signIn);

	}

	public void enterUserName(String Uname) {

		sendKeysToTextBox(emailId,Uname);

	}

	public void enterPassword(String pwd) {

		sendKeysToTextBox(passWord,pwd);

	}
	
	public void submitButtonClick() {

		buttonClick(submit);

	}
	
	public HomePage LogIn (String Uname,String Password) throws InterruptedException {
		
		sigInClick();
		Thread.sleep(3000);
		enterUserName(Uname);
		enterPassword(Password);
		submitButtonClick();
		waitForPageTitle("My account - My Store");
		return new HomePage(driver);
		
		
		
	}


}
