// HomePage Feature implemented

package com.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObjects.HomePage;
import com.PageObjects.LogInPage;
import com.PageObjects.casualDresPage;

public class HomePageTest extends BaseTest {
	

	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void casualDresspageTitleTest() throws InterruptedException {
		
		LogInPage loginPage=page.getInstance(LogInPage.class);
		Thread.sleep(3000);
	//	log.info("Enter the username and password:");
		HomePage Home=loginPage.LogIn(usernameId, password);
		Home.selectCasualDress();
	//	log.info("User navigated to the CasualDressPage");
		String title=Home.casualDressPageTitle();
		Assert.assertEquals(title, "Casual Dresses - My Store");
	}
	
	public void casualDressTextTest() throws InterruptedException {
		LogInPage loginPage=page.getInstance(LogInPage.class);
		Thread.sleep(3000);
	//	log.info("Enter the username and password:");
		HomePage Home=loginPage.LogIn(usernameId, password);
		casualDresPage casual=Home.selectCasualDress();
		String text=Home.casualDresstextCheck();
	//	log.info("Asserting the casualDressText");
		Assert.assertEquals(text, "CASUAL DRESSES");
		
	}
}
