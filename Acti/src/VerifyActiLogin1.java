

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class VerifyActiLogin1 extends BaseTest{
FileLib flib;
WebdriverCommonLib wlib;
EnterTimeTrackPage ettp;
ActiLoginPage alp;


	@Test(priority=1)
	public void verifyActiValidLoginTest() throws Throwable  {
	
		flib=new FileLib();
		wlib=new WebdriverCommonLib();
		ettp=new EnterTimeTrackPage(driver);
		
		String username = flib.getKeyPropValue(PROPERTY_PATH, "username");
		String password = flib.getKeyPropValue(PROPERTY_PATH, "password");
		ActiLoginPage alp=new ActiLoginPage(driver);
		alp.login(username, password);
		String expectedHomeTitle = flib.getCellData(EXCEL_PATH, "Invalid", 1, 5);
		wlib.verifyAssert(wlib.getPageTitle(), expectedHomeTitle, "Home Page");
		Thread.sleep(2000);
		ettp.clicklogoutLink();
		Thread.sleep(2000);
	}
	
	@Test(priority=2)
	public void verifyActiInvalidLoginTest() throws Throwable  {
		
		flib=new FileLib();
		wlib=new WebdriverCommonLib();
		 
		 
		 alp=new ActiLoginPage(driver);
		 int rowCount = flib.getRowCount(EXCEL_PATH, "Invalid");
		 SoftAssert sa = null;
		 for(int i=1;i<=rowCount;i++)
		 {
		 alp.login(flib.getCellData(EXCEL_PATH, "Invalid", i, 0), flib.getCellData(EXCEL_PATH, "Invalid", i, 1));
		 sa=new SoftAssert();
		 wlib.verifySoftAssert(alp.setErrMsg(), flib.getCellData(EXCEL_PATH, "Invalid", 1, 3), "Error Message");
		 flib.setCellData(EXCEL_PATH, "Invalid", i, 2, "PASS");
		 
		 
		 }
		 sa.assertAll();
	}
}
