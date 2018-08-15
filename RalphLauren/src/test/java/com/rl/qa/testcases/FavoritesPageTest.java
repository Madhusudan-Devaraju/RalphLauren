package com.rl.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rl.qa.base.TestBase;
import com.rl.qa.pages.AccountLandingPage;
import com.rl.qa.pages.FavoritesPage;
import com.rl.qa.pages.LoginPage;

public class FavoritesPageTest extends TestBase
{
	AccountLandingPage accountlandingpage;
	FavoritesPage favoritespage;
	LoginPage loginpage;

	public FavoritesPageTest()
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


	@Test
	public void verifyNumberOfItems()
	{
		favoritespage = accountlandingpage.navigateToFav();
		int i = favoritespage.verifyNumberofFavItems();
		int p = favoritespage.verifyNumberoFProducts();
		Assert.assertEquals(i, p);
	}

	@AfterMethod
	public void close()
	{
		driver.quit();
	}
}
