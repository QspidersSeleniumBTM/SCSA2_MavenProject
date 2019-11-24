

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyActiLogin extends BaseTest{

	EnterTimeTrackPage ettp;
	ActiLoginPage alp;
	FileLib flib;
	WebdriverCommonLib wlib;
	
	
	@Test(enabled=false)
	public void verifyActiValidLoginTest()  {
	
		Reporter.log("Home Page is Displayed==> PASSED",true);
	}
	
	
	@Test
	public void verifyActiInvalidLoginTest() throws Throwable {
		flib=new FileLib();
		wlib=new WebdriverCommonLib();
		ettp=new EnterTimeTrackPage(driver);
		 
		// ettp.clicklogoutLink();
		 
		 
		 alp=new ActiLoginPage(driver);
		 int rowCount = flib.getRowCount(EXCEL_PATH, "Invalid");
		 SoftAssert sa = null;
		 for(int i=1;i<=rowCount;i++)
		 {
		 alp.login(flib.getCellData(EXCEL_PATH, "Invalid", i, 0), flib.getCellData(EXCEL_PATH, "Invalid", i, 1));
		 sa=new SoftAssert();
		 sa.assertEquals(alp.setErrMsg(), flib.getCellData(EXCEL_PATH, "Invalid", 1, 3));
		 //wlib.verifySoftAssert(alp.setErrMsg(), flib.getCellData(EXCEL_PATH, "Invalid", 1, 3), "Error Message");
		 flib.setCellData(EXCEL_PATH, "Invalid", i, 2, "PASS");
		 
		 
		 }
		 sa.assertAll();
	}
}
