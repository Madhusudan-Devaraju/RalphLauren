package com.rl.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rl.qa.base.TestBase;

public class LoginPage extends TestBase {
	// Page objects
	@FindBy(xpath = "(//input[@type='email'])[1]")
	private WebElement un;

	@FindBy(xpath = "//input[@placeholder='Password *']")
	private WebElement pwd;

	@FindBy(xpath = "(//button[@type='submit'])[4]")
	private WebElement login;

	@FindBy(xpath = "//span[text()='Ralph Lauren Home']")
	private WebElement logo;

	@FindBy(xpath = "(//a[@id='password-reset'])[2]")
	private WebElement forgotpwd;

	@FindBy(xpath = "(//button[@class='createAccount'])[2]")
	private WebElement createAccount;

	// initializing page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String LoginPageTitle() {
		return driver.getTitle();
	}

	public boolean LoginPageLogo() {
		return logo.isDisplayed();
	}

	public AccountLandingPage login(String username, String password) throws IOException {
		un.sendKeys(username);
		pwd.sendKeys(password);
		login.click();
		return new AccountLandingPage();
	}

	public RegistrationPage ClickOnCreateAccount() {
		createAccount.click();
		return new RegistrationPage();
	}
}