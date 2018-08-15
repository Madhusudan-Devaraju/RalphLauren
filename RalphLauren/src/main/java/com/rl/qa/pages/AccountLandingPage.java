package com.rl.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.rl.qa.base.TestBase;

public class AccountLandingPage extends TestBase 
{
	@FindBy (xpath = "//img[contains(@src, 'wishlist.jpg')]")
	private WebElement favoritesButton;
	
	@FindBy (xpath = "//img[contains(@src, 'personaldata.jpg')]")
	private WebElement personaldataButton;
	
	@FindBy (xpath = "//img[contains(@src, 'addresses.jpg')]")
	private WebElement addressesButton;
	
	@FindBy (xpath = "//img[contains(@src, 'paymentsettings.jpg')]")
	private WebElement paymentsettingsButton3;
	
	@FindBy (xpath = "//div[@class='secondary-navigation']//h2")
	private WebElement username;
	
	public AccountLandingPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyUsername()
	{
		String customername = username.getText();
		return customername;
	}
	
	public String favPageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public FavoritesPage navigateToFav()
	{
		favoritesButton.click();
		return new FavoritesPage();
	}
	
	public PersonalData navToPD()
	{
		personaldataButton.click();
		return new PersonalData();
	}
	
	public AddressPage navToAdd()
	{
		addressesButton.click();
		return new AddressPage();
	}
}
