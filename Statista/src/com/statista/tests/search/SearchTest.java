package com.statista.tests.search;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;import java.util.regex.Pattern;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.statista.pages.ContactUsPage;
import com.statista.pages.HomePage;
import com.statista.pages.SearchResultsPage;
import com.statista.utilites.Configuration;

public class SearchTest {

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
	public void searchTest() {
	HomePage homepage = new HomePage(driver);
	homepage.searchMain.sendKeys("homelessness"+Keys.RETURN);
	SearchResultsPage search = new SearchResultsPage(driver);
	System.out.println(Configuration.getNumbers(
			search.resultsCountLabel.getText()));
	assertTrue(Configuration.getNumbers(
			search.resultsCountLabel.getText())>0);
	
	}
	

}
