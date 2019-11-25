package genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.CRMLoginPage;
import pages.ZohoCRMHomePage;

public class BaseTestCRM implements IAutoCostantsCRM{
	public static WebDriver driver;
	FileLibraryCRM flib;
	WebDriverCommonLibraryCRM wlib;
	@BeforeClass
public void openBrowser() throws Throwable {
	flib=new FileLibraryCRM();
	wlib=new WebDriverCommonLibraryCRM();
	String browser = flib.getPropertyValue(PROPERTY_PATH, "browser");
	if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox")) {
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		driver=new FirefoxDriver();
	}
	else
	{
		Reporter.log("enter proper browser",true);
	}
	driver.get(flib.getPropertyValue(PROPERTY_PATH, "url"));
	flib.getCellData(EXEL_PATH, "Invalid", 1, 4);
	String expectedTitle=flib.getCellData(EXEL_PATH, "Invalid", 1, 4);
	wlib.verifyAssert(wlib.getPageTitle(), expectedTitle, "Login page");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
}
public void LoginToApp() throws Throwable {
	flib=new FileLibraryCRM();
	wlib=new WebDriverCommonLibraryCRM();
	String username = flib.getPropertyValue(PROPERTY_PATH, "username");
	String password = flib.getPropertyValue(PROPERTY_PATH, "password");
	CRMLoginPage clp=new CRMLoginPage(driver);
	clp.login(username, password);
	String expectedTitle=flib.getCellData(EXEL_PATH, "Invalid", 1, 5);
	wlib.verifyAssert(wlib.getPageTitle(), expectedTitle, "Home page");
	
}
public void LogoutFromApp() throws Throwable {
	Thread.sleep(3000);
	ZohoCRMHomePage zchp=new ZohoCRMHomePage(driver);
	zchp.clickLogoutbtn();
	
}
@AfterClass
public void tearDown() {
	driver.quit();
}
}
