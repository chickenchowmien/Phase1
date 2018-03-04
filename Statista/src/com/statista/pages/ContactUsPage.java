package com.statista.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	private WebDriver driver;
	public ContactUsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public final static String PAGE_TITLE ="Corporate Account Request | Statista";
	
	
}
