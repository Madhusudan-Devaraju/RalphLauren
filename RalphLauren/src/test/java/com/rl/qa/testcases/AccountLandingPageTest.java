package com.rl.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rl.qa.base.TestBase;
import com.rl.qa.pages.AccountLandingPage;
import com.rl.qa.pages.FavoritesPage;
import com.rl.qa.pages.LoginPage;

public class AccountLandingPageTest extends TestBase
{
	LoginPage loginpage;
	AccountLandingPage accountlandingpage;
	FavoritesPage favoritespage;
	public AccountLandingPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage = new LoginPage();
		accountlandingpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test (priority=1)
	public void verifyAccountLandingPageTitleTest()
	{
		String title = accountlandingpage.favPageTitle();
		Assert.assertEquals(title, "Ralph Lauren - Account | Ralph Lauren | 103.1.11 - controllers\", \"account landing page did not match");
	}

	@Test (priority=3)
	public void navigateToFavPageTest()
	{
		favoritespage = accountlandingpage.navigateToFav();
	}

	@Test (priority = 2)
	public void verifyCustomeNameTest()
	{
		String custName = accountlandingpage.verifyUsername();
		Assert.assertEquals(custName, "TEST", "username is not TEST");
	}

	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}
