package com.statista.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="loginStat_username")
	public WebElement fieldUsername;
	@FindBy(id="loginStat_password")
	public WebElement fieldPassword;
	@FindBy(id="loginStat_submitLogin")
	public WebElement loginButton;
	@FindBy(id="loginStat_submitLogin")
	public WebElement buttonLoginSubmit;
}
