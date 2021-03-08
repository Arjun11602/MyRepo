package com.Test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.PageObjects.HomePage;
import com.PageObjects.LogInPage;
import com.PageObjects.OrderPage;
import com.PageObjects.casualDresPage;

public class OrderpageTest extends BaseTest {

	
	public OrderpageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void proceedtoCheckOutOrderTest() throws InterruptedException {
		
		LogInPage loginPage=page.getInstance(LogInPage.class);
		Thread.sleep(3000);
		HomePage Home=loginPage.LogIn(usernameId, password);
	//	log.info("Enters the username and password");
		casualDresPage casual=Home.selectCasualDress();
		OrderPage order=casual.proceedToCheckOut();
		order.proccedToCheckoutOrder();
		
	}
}
