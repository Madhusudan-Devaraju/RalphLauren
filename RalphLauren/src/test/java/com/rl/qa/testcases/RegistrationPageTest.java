package com.rl.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
	String sheetName = "CreateUser";

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

	@DataProvider
	public Object[][] getTestData()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test (dataProvider="getTestData")
	public void createUser(String firstname, String lastname, String emailid, String confirmemailid, String passowrd, String confirmpassword) throws InterruptedException
	{
		//String fname = util.getData(0, 1, 0);
		registrationpage.eneterFname(firstname);
		Thread.sleep(1000);

		//String lname = util.getData(0, 1, 1);
		registrationpage.eneterlname(lastname);
		Thread.sleep(1000);

		//String email = util.getData(0, 1, 2);
		registrationpage.eneteremail(emailid);
		Thread.sleep(1000);

		//String cemail = util.getData(0, 1, 3);
		registrationpage.confirmemail(confirmemailid);
		Thread.sleep(1000);

		//String pwd = util.getData(0, 1, 4);
		registrationpage.eneterpwd(passowrd);
		Thread.sleep(1000);

		//String cpwd = util.getData(0, 1, 5);
		registrationpage.confirmpwd(confirmpassword);
		Thread.sleep(1000);

		//registrationpage.clickCheckbox();

		registrationpage.clickCreateAccount();
		String title = driver.getTitle();
		Assert.assertEquals(title, "Ralph Lauren - Account | Ralph Lauren | 103.1.11 - controllers");
		Thread.sleep(2000);
	}

	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}