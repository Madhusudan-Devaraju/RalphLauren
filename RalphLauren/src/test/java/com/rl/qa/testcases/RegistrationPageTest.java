package com.rl.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rl.qa.base.TestBase;
import com.rl.qa.pages.LoginPage;
import com.rl.qa.pages.RegistrationPage;

public class RegistrationPageTest extends TestBase
{
	RegistrationPage registrationpage;
	LoginPage loginpage;
	public RegistrationPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		initialization();
		registrationpage = new RegistrationPage();
		loginpage = new LoginPage();
	}
	
	@Test
	public void verifyPageTitle()
	{
		String atitle = registrationpage.VerifyPageTitle();
		Assert.assertEquals(atitle, "Ralph Lauren - Account Login | Ralph Lauren | 103.1.11 - controllers");
		loginpage.ClickOnCreateAccount();
	}
	
	@DataProvider
	public void getTestData()
	{
		
	}
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}
