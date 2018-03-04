package com.statista.tests.registration;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.statista.pages.HomePage;
import com.statista.pages.LoginPage;
import com.statista.utilites.Configuration;



public class LoginTest {
	WebDriver driver;

	@BeforeClass(alwaysRun =true)
	public void setUp() {
		System.setProperty(Configuration.getProperty("CHROME_DRIVER"), 
				Configuration.getProperty("CHROME_PATH"));
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Configuration.getProperty("url"));

	}

	@AfterClass(alwaysRun =true)
	 public void shutDown() {
		driver.quit();
	}

	@Test(groups="smoke")
	public void positiveLoginTest() {
	HomePage homepage = new HomePage(driver);
	homepage.buttonLogin.click();
	LoginPage loginpage = new LoginPage(driver);
	
	loginpage.fieldUsername.sendKeys(Configuration.getProperty("username"));
	loginpage.fieldPassword.sendKeys(Configuration.getProperty("password"));
	loginpage.buttonLoginSubmit.click();
	assertTrue(homepage.labelUserID.getText().contains("You are using the account of James Lacson"));
	
	}
}
