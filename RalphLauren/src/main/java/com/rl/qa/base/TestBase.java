package com.rl.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.rl.qa.util.SeleniumEventListener;
import com.rl.qa.util.TestUtil;

public class TestBase 
{
	//both these properties can be used in child classes as well
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver event;
	public static SeleniumEventListener sel;

	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("E:\\MyWorkspace\\RalphLauren\\src\\main\\java\\com\\rl\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium Dependencies\\BrowserExecutables\\chromedriver_win32_v2.41.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "E:\\Selenium Dependencies\\BrowserExecutables\\geckodriver_win64_v0.21.0.exe");
			driver = new FirefoxDriver();
		}

		event = new EventFiringWebDriver(driver);
		sel = new SeleniumEventListener();
		event.register(sel);
		driver = event;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}