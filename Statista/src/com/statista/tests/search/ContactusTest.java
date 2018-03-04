package com.statista.tests.search;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.statista.pages.ContactUsPage;
import com.statista.pages.HomePage;
import com.statista.utilites.Configuration;

public class ContactusTest {
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
	public void contactusTest() {
		HomePage homepage = new HomePage(driver);
//		WebDriverWait wait = new WebDriverWait(driver,5);
//		wait.pollingEvery(1, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.id("homepageSearch")));
		homepage.buttonContactUs.click();
		ContactUsPage page = new ContactUsPage(driver);
		assertEquals(page.PAGE_TITLE.trim(),driver.getTitle());
		
	}
}