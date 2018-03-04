package com.statista.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class TopMenuPage {
	//Home Menu Logo
	@FindBy(id="statistaLogo")
	public WebElement homeLogoIcon;
	public void goToHomePage() {
		homeLogoIcon.click();
	}
	//top menu drop downs section
	//prices
		@FindBy(xpath="//a[@class='navMain__navigationItem'][contains(text(),'Prices')]")
		public WebElement pricesDropDownMenu;
		@FindBy(xpath="//a[@class='navMain__navigationItem'][contains(text(),'Prices')]/i")
		public WebElement pricesDropDownArrow;
	//prices drop down menu selections, must hover over
		@FindBy(xpath="//a[@href='/accounts/'][contains(text(),'Single')]")
		public WebElement pricesMenuItemSingleAccounts;
		@FindBy(xpath="//a[@href='/accounts/corporate/'][contains(text(),'Corporate')]")
		public WebElement pricesMenuItemCorporateSolutions;
		@FindBy(xpath="//a[@href='/accounts/education/'][contains(text(),'Universities')]")
		public WebElement pricesMenuItemUniversities;
	//statistics 
		
		
		
	//statistics drop down menu area
		
		
		
		
		
	//reports	
		@FindBy(xpath="//a[@class='navMain__navigationItem'][contains(text(),'Reports')]")
		public WebElement reportsDropDownMenu;
		@FindBy(xpath="//a[@class='navMain__navigationItem'][contains(text(),'Reports')]/i")
		public WebElement reportsDropDownArrow;
}
