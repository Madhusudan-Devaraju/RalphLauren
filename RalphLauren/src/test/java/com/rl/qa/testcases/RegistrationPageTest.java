package com.rl.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rl.qa.base.TestBase;
import com.rl.qa.pages.LoginPage;
import com.rl.qa.pages.RegistrationPage;
import com.rl.qa.util.TestUtil;

public class RegistrationPageTest extends TestBase
{
	RegistrationPage registrationpage;
	LoginPage loginpage;
	TestUtil util;

	public RegistrationPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		initialization();
		util = new TestUtil();
		registrationpage = new RegistrationPage();
		loginpage = new LoginPage();
		loginpage.ClickOnCreateAccount();
	}

	//	@Test
	//	public void verifyPageTitle()
	//	{
	//		String atitle = registrationpage.VerifyPageTitle();
	//		Assert.assertEquals(atitle, "Ralph Lauren - Account Login | Ralph Lauren | 103.1.11 - controllers");
	//	}

	@Test
	public void createUser() throws InterruptedException
	{
		String fname = util.getData(0, 1, 0);
		registrationpage.eneterFname(fname);
		Thread.sleep(1000);

		String lname = util.getData(0, 1, 1);
		registrationpage.eneterlname(lname);
		Thread.sleep(1000);

		String email = util.getData(0, 1, 2);
		registrationpage.eneteremail(email);
		Thread.sleep(1000);

		String cemail = util.getData(0, 1, 3);
		registrationpage.confirmemail(cemail);
		Thread.sleep(1000);

		String pwd = util.getData(0, 1, 4);
		registrationpage.eneterpwd(pwd);
		Thread.sleep(1000);

		String cpwd = util.getData(0, 1, 5);
		registrationpage.confirmpwd(cpwd);
		Thread.sleep(1000);

		//registrationpage.clickCheckbox();

		registrationpage.clickCreateAccount();
		String title = driver.getTitle();
		Assert.assertEquals(title, "Ralph Lauren - Account | Ralph Lauren | 103.1.11 - controllers");

	}

	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}