package com.statista.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class HomePage {
	private WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="homepageSearch")
	public WebElement searchMain;
	@FindBy(className="button button--primary colOne")
	public WebElement buttonMainSearch;
	@FindBy(xpath="(//a[@href='/login/'])[2]")
	public WebElement buttonLogin;
	@FindBy(xpath="//p[@class='animated fadeInUp']")
	public WebElement labelUserID;
	@FindBy(xpath="//*[contains(text(),'Contact us')]")
	public WebElement buttonContactUs;
}
