package com.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObjects.HomePage;
import com.PageObjects.LogInPage;

public class LoginTest extends BaseTest {

	
	

	public LoginTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void signInToApplication() throws InterruptedException {
		
		LogInPage loginPage=page.getInstance(LogInPage.class);
		Thread.sleep(3000);
		//log.info("Entering the username and password");
		HomePage Home=loginPage.LogIn(usernameId, password);
		String title=page.getPageTitle();
		//log.info("Asserting the HomePageTitle");
		Assert.assertEquals(title, "My account - My Store");
	}
	
}
