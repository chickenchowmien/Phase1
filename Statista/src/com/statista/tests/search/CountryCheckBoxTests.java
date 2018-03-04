package com.statista.tests.search;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.statista.pages.ContactUsPage;
import com.statista.pages.HomePage;
import com.statista.pages.SearchResultsPage;
import com.statista.utilites.Configuration;

public class CountryCheckBoxTests {
	WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		System.setProperty(Configuration.getProperty("CHROME_DRIVER"), Configuration.getProperty("CHROME_PATH"));
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Configuration.getProperty("url"));

	}

	@AfterClass(alwaysRun = true)
	public void shutDown() {
		//driver.quit();
	}

	@Test(groups = "smoke")
	public void checkBoxCountryTest() {
		String country = "United Kingdom";
		
		HomePage homepage = new HomePage(driver);
		homepage.searchMain.sendKeys("homelessness" + Keys.RETURN);
		SearchResultsPage searchpage = new SearchResultsPage(driver);
		searchpage.getCheckBoxCountry(country).click();
		searchpage.buttonRefreshSearch.click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			wait.pollingEvery(1, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//span[@class='filterTag__text'][contains(text(),'" + country + "')]")));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		assertTrue(driver.findElement(By.xpath("//span[@class='filterTag__text'][contains(text(),'" + country + "')]"))
				.isDisplayed());
	}

}
