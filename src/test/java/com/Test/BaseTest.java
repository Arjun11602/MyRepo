//Login Features impplemented

package com.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.PageObjects.BasePage;
import com.PageObjects.Page;
import com.sun.tools.javac.util.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public Page page;
	public Logger log;
	public Properties prop;
	public static String usernameId;
	public static String password;

	public BaseTest() throws IOException {

		prop=new Properties();
		File file=new File(System.getProperty("user.dir"),
				"//src//main//resources//Configuration.properties"); 
		FileInputStream fis =new FileInputStream(file); 
		prop.load(fis); 
		usernameId=prop.getProperty("Username"); 
		System.out.println(usernameId); 
		password=prop.getProperty("Password"); 
		System.out.println(password);
	}


	@BeforeMethod
	@Parameters({"browser","URL"})
	public void setUp(String browser, String URL) {

		if(browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get(URL);
		}

		else if(browser.equals("edge")) {

			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.get(URL);
		}

		else if(browser.equals("ff")){

			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.get(URL);
		}
		page=new BasePage(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);



		// log.getLogger(BaseTest.class);
		// PropertyConfigurator.configure("Log4j.properties");
	} 

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
