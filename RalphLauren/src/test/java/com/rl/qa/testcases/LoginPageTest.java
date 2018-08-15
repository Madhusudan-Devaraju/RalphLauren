package com.rl.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rl.qa.base.TestBase;
import com.rl.qa.pages.AccountLandingPage;
import com.rl.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginpage;
	AccountLandingPage accountlandingpage;
		
	public LoginPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage = new LoginPage();
	}
	@Test (priority=1)
	public void TitleTest()
	{
		String title = loginpage.LoginPageTitle();
		Assert.assertEquals(title, "Ralph Lauren - Account Login | Ralph Lauren | 103.1.11 - controllers");
	}
	
	@Test (priority=2)
	public void logoTest()
	{
		Boolean flag = loginpage.LoginPageLogo();
		Assert.assertTrue(flag);
	}
	
	@Test (priority=3)
	public void loginTest()
	{
		accountlandingpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}
