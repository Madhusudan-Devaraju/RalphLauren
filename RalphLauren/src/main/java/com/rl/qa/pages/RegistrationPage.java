package com.rl.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rl.qa.base.TestBase;

public class RegistrationPage extends TestBase
{
	@FindBy (xpath = "//input[@placeholder = 'Name *']")
	private WebElement fname;

	@FindBy (xpath = "//input[@placeholder = 'Surname *']")
	private WebElement lname;

	@FindBy (xpath = "//input[@placeholder = 'Email Address *']")
	private WebElement email;

	@FindBy (xpath = "//input[@placeholder = 'Confirm Email Address *']")
	private WebElement confirmemail;

	@FindBy (xpath = "//input[@placeholder = 'Password *']")
	private WebElement pwd;

	@FindBy (xpath = "//input[@placeholder = 'Re-Enter Password *']")
	private WebElement confirmpwd;

	@FindBy (xpath = "(//button[@type = 'submit'])[4]")
	private WebElement createaccountbutton;

	@FindBy (xpath = "//input[@id='dwfrm_profile_customer_addtoemaillist']")
	private WebElement chkbox;

	//initializing objects
	public RegistrationPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String VerifyPageTitle()
	{
		String title = driver.getTitle();
		return title;
	}

	//enter first name
	public void eneterFname(String first_name)
	{
		fname.sendKeys(first_name);
	}

	//enter last name
	public void eneterlname(String last_name)
	{
		lname.sendKeys(last_name);
	}

	//enter email
	public void eneteremail(String email1)
	{
		email.sendKeys(email1);
	}

	//confirm email
	public void confirmemail(String email2)
	{
		confirmemail.sendKeys(email2);
	}
	//enter pwd
	public void eneterpwd(String password)
	{
		pwd.sendKeys(password);
	}
	//confirm pwd
	public void confirmpwd(String confirmpassword)
	{
		confirmpwd.sendKeys(confirmpassword);
	}

	//click create account button
	public AccountLandingPage clickCreateAccount()
	{
		createaccountbutton.click();
		return new AccountLandingPage();
	}

	//click subscription checkbox
	public void clickCheckbox()
	{
		chkbox.click();
	}

}
