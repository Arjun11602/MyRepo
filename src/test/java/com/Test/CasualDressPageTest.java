package com.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObjects.BasePage;
import com.PageObjects.HomePage;
import com.PageObjects.LogInPage;
import com.PageObjects.OrderPage;
import com.PageObjects.casualDresPage;

public class CasualDressPageTest extends BaseTest {

	
	public CasualDressPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void priceTagCheckTest() throws InterruptedException {
		
		LogInPage loginPage=page.getInstance(LogInPage.class);
		Thread.sleep(3000);
	//	log.info("Enters the username and password");
		HomePage Home=loginPage.LogIn(usernameId, password);
		casualDresPage casual=Home.selectCasualDress();
		String text=casual.priceTagcheck();
		if(text.equals("$26.00")) {
			Assert.assertEquals(true, false);
		}
		else {
			try {
				BasePage.TakeScreenShot(driver);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Assert.assertEquals(true, false);
		}
	}
	
	public void proceedToCheckOutText() throws InterruptedException {
		LogInPage loginPage=page.getInstance(LogInPage.class);
		Thread.sleep(3000);
		HomePage Home=loginPage.LogIn(usernameId, password);
	//	log.info("Enters the username and password");
		casualDresPage casual=Home.selectCasualDress();
		//casual.proceedToCheckOut();
		OrderPage order=casual.proceedToCheckOut();
		String title=page.getPageTitle();
		//log.info("asserting the orderpagetitle");
		Assert.assertEquals(title, "Order - My Store");
		
	}
}
