package com.rl.qa.util;

/*************************************** PURPOSE **********************************
- This class implements the WebDriverEventListener, which is included under events.
The purpose of implementing this interface is to override all the methods and define certain useful  Log statements 
which would be displayed/logged as the application under test is being run.
Do not call any of these methods, instead these methods will be invoked automatically
as an when the action done (click, findBy etc). 
 */


import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.rl.qa.base.TestBase;

public class SeleniumEventListener extends TestBase implements WebDriverEventListener 
{
	
	@Override
	public void afterAlertAccept(WebDriver driver) {
		System.out.println("clicked on okay button");

	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("clicked on dismiss button");

	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] arg2) {
		//System.out.println("Element value changed to:" + element.toString());

	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("clicked on "+ element.toString());

	}

	@Override
	public void afterFindBy(By arg0, WebElement element, WebDriver driver) {
		System.out.println("found element "+ element.toString());

	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		//System.out.println("the text is "+ text);

	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		//System.out.println("navigated back");

	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		//System.out.println("navigated to forward");

	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("navigated to " + url);

	}

	@Override
	public void afterScript(String string, WebDriver driver) {
		System.out.println("executed JS "+ string);

	}

	@Override
	public void afterSwitchToWindow(String string, WebDriver driver) {
		System.out.println("switched to window " + string);

	}

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("before accepting alert");

	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		System.out.println("before dismissing alert");

	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] arg2) {
		//System.out.println("Value of the" + element.toString() + " before any changes made");

	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("btrying to click element "+element.toString());

	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("trying to find elemnt by "+ by.toString());

	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeGetText(WebElement elemnt, WebDriver driver) {
		//System.out.println("beofre getting text "+ elemnt.toString());

	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		//System.out.println("before navigating back");

	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		//System.out.println("before navigating forward");

	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("before navigatong to " + url);

	}

	@Override
	public void beforeScript(String string, WebDriver driver) {
		System.out.println("starting the script");

	}

	@Override
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		System.out.println("switched to window");

	}

	@Override
	public void onException(Throwable error, WebDriver driver) {
		try {
			TestUtil.takeScreenShot();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}


}