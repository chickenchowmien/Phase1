package com.statista.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchResultsPage extends TopMenuPage{
	private WebDriver driver;
	public SearchResultsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	

	//big search box
	@FindBy(id="q")
	public WebElement searchMain;
	//search button for main search box
	@FindBy(className="fa-search fa")
	public WebElement buttonMainSearch;
	@FindBy(xpath="//span[@data-searchrefresh='Refresh Search']")
	public WebElement buttonRefreshSearch;
	//search results return links containing string method
	public WebElement searchResultsLinks(String linkContaingText) {
		return driver.findElement(By.xpath("//h2[contains(text(),'"+linkContaingText+"')]"));
	}
	//sort by select box
	@FindBy(xpath="//select[@id='sortMethod']")
	public WebElement selectBoxSort;
	public void selectBoxSort(String s) {
		Select select = new Select(selectBoxSort);
		select.selectByValue(s);
	}
	//location focus select box
	@FindBy(xpath="//select[@id='isRegionPref']")
	public WebElement selectBoxLocationFocus;
	public void selectBoxLocationFocus(String s) {
		Select select = new Select(selectBoxLocationFocus);
		select.selectByValue(s);
	}
	//statistics section
	@FindBy(xpath="//input[@id='statistics']")
	public WebElement checkboxStatistics;
	@FindBy(xpath="//input[@id='forecasts']")
	public WebElement checkboxForecast;
	@FindBy(xpath="//input[@id='infos']")
	public WebElement checkboxInfographics;
	@FindBy(xpath="//input[@id='topics']")
	public WebElement checkboxTopics;
	//studies & reports
	@FindBy(xpath="//input[@id='dossiers']")
	public WebElement checkboxDossiers;
	@FindBy(xpath="//input[@id='groupA']")
	public WebElement checkboxStatista;
	@FindBy(xpath="//input[@id='groupB']")
	public WebElement checkboxIndustry;
	@FindBy(xpath="//input[@id='groupC']")
	public WebElement checkboxAdditional;
	//expert tools section
	@FindBy(xpath="//input[@id='dmo']")
	public WebElement checkboxDigital;
	@FindBy(xpath="//input[@id='cmo']")
	public WebElement checkboxConsumer;
	@FindBy(xpath="//input[@id='companies']")
	public WebElement checkboxCompanies;
	//search accuracy section
	@FindBy(xpath="//input[@id='accuracy_0']")
	public WebElement checkboxWideAccuracy;
	@FindBy(xpath="//input[@id='accuracy_1']")
	public WebElement checkboxNormalAccuracy;
	@FindBy(xpath="//input[@id='accuracy_2']")
	public WebElement checkboxHighAccuracy;
	// regions check box
	@FindBy(xpath="//select[@id='isoregion']")
	public WebElement selectBoxRegions;
	public void selectBoxRegions(String s) {
		Select select = new Select(selectBoxRegions);
		select.selectByVisibleText(s);
	}
	//country search and select section
	@FindBy(xpath="//input[@id='isocountrySearch']")
	public WebElement searchBoxCountry;

	public WebElement getCheckBoxCountry(String countryName) {
		selectBoxRegions("All");
		return driver.findElement(By.xpath("//span[contains(text(),'"+countryName+"')]"));
	}
	public WebElement getFilterTag(String tagName) {
		return driver.findElement(By.xpath("//span[@class='filterTag__text'][contains(text(),'"+tagName+"')]"));
	}
	
	
 	
	//industry select box
	@FindBy(xpath="//select[@id='category']")
	public WebElement selectBoxIndustry;
	public void selectBoxIndustry(String s) {
		Select select = new Select(selectBoxIndustry);
		select.selectByValue(s);
	}
	//publication date select box
	@FindBy(xpath="//select[@id='interval']")
	public WebElement  selectBoxPublicationDate;
	public void selectBoxPublicationDate(String s) {
		Select select = new Select(selectBoxPublicationDate);
		select.selectByValue(s);
	}
	//archive select box
	@FindBy(xpath="//select[@id='archive']")
	public WebElement  selectBoxArchive;
	public void selectBoxArchive(String s) {
		Select select = new Select(selectBoxArchive);
		select.selectByValue(s);
	}
	//RESET ALL FILTERS
	@FindBy(id="js-reset-all-filters")
	public WebElement  resetAllFiltersButton;
	
	//go to page number web elements method
	public WebElement getGoToPageNumberElement(String pageNumber) {
		return driver.findElement(By.xpath("//a[@class='pagination__link'][contains(text(),'"+pageNumber+"')]"));
	}
	@FindBy(xpath="//h4[@class='hl-module hideMobile']")
	public WebElement resultsCountLabel;
	

	
}
