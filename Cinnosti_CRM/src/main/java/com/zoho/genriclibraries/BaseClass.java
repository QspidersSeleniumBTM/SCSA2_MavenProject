package com.zoho.genriclibraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.zoho.pages.Home_Page;
import com.zoho.pages.Login_Page;

public class BaseClass implements IConstants{

	public static WebDriver driver;
	File_Libraries flib = new File_Libraries();
	WebdriverGenericMethods wgm;
	Login_Page lp;
	Home_Page hp;
	
	@BeforeClass(enabled=true)
	public void openBrowser() throws Throwable
	{
		System.out.println("Im IN");
		wgm= new WebdriverGenericMethods();
		String browserValue=flib.getKeyPropVlaue(PROPERTY_PATH, "browser");
		if(browserValue.equalsIgnoreCase("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver = new ChromeDriver();
		}
		else if(browserValue.equalsIgnoreCase("firefox"))
		{
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver = new FirefoxDriver();
		} else System.out.println("Enter Correct Browser name");
		driver.manage().window().maximize();
		driver.get(flib.getKeyPropVlaue(PROPERTY_PATH, "url"));
		String LPActual=wgm.getPageTitle();
		String LPExpected=flib.getCellData(EXCEL_PATH, "Title", 3, 0);
		wgm.verifyAssert(LPActual, LPExpected,"Login Page");
		
	}
//	 String homewh;
	@BeforeMethod
	public void loginToApp() throws Throwable
	{
		lp=new Login_Page(driver);
		wgm=new WebdriverGenericMethods();
		hp=new Home_Page(driver);
		String username= flib.getKeyPropVlaue(PROPERTY_PATH, "username");
		String password=flib.getKeyPropVlaue(PROPERTY_PATH, "password");
		lp.login(username, password);
		String LPActual=hp.getHomePage();
		//System.out.println(LPActual);
		String LPExpected=flib.getCellData(EXCEL_PATH, "Title", 5, 0);
		wgm.verifyAssert(LPActual, LPExpected,"Home Page");
//		 homewh = driver.getWindowHandle();
	}
	@AfterMethod(enabled = true)
	public void logouttFromApp()
	{
		//driver.switchTo().window(homewh);
		hp = new Home_Page(driver);
		hp.clickLogout();
	}
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		driver.close();
	}


}
