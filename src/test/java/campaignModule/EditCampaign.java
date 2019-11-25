package campaignModule;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLib.BaseTestCRM;
import genericLib.FileLibraryCRM;
import genericLib.WebDriverCommonLibraryCRM;
import pages.CRMLoginPage;
import pages.CampaignDetailsPage;
import pages.CreateCampaignPage;
import pages.EditCampaignPage;
import pages.ZohoCRMDisplayingCustomViewDetailsPage;
import pages.ZohoCRMHomePage;

public class EditCampaign extends BaseTestCRM{
	FileLibraryCRM flib;
	WebDriverCommonLibraryCRM wlib;
	ZohoCRMHomePage zchp;
	CRMLoginPage clp;
	CreateCampaignPage ccp;
	ZohoCRMDisplayingCustomViewDetailsPage zcdcvd;
	CampaignDetailsPage cdp;
	EditCampaignPage ec;
	
	//@Test
	public void verifyEditCampaign() throws Throwable {
		BaseTestCRM btc=new BaseTestCRM();
		wlib=new WebDriverCommonLibraryCRM();
		zchp=new ZohoCRMHomePage(driver);
		flib=new FileLibraryCRM();
		btc.LoginToApp();
		Thread.sleep(2000);
		zchp.clickCampaignlink();
		
		String ZohoCRMDisplayingCustomViewDetailsTitle = flib.getCellData(EXEL_PATH, "CreateCampaign", 1, 10);
		wlib.verifyAssert(wlib.getPageTitle(), ZohoCRMDisplayingCustomViewDetailsTitle, "Zoho CRM Displaying Custom View Details page");
		
		zcdcvd=new ZohoCRMDisplayingCustomViewDetailsPage(driver);
		zcdcvd.clickNewCampaignbtn();
		Thread.sleep(2000);
		ccp=new CreateCampaignPage(driver);
		
		String campaignName=flib.getCellData(EXEL_PATH, "CreateCampaign", 1, 0);
		String startdate=flib.getCellData(EXEL_PATH, "CreateCampaign", 1, 1);
		String expectedrevenue=flib.getCellData(EXEL_PATH, "CreateCampaign", 1, 2);
		String actualCost=flib.getCellData(EXEL_PATH, "CreateCampaign", 1, 3);
		String numsent=flib.getCellData(EXEL_PATH, "CreateCampaign", 1, 4);
		String endtdate=flib.getCellData(EXEL_PATH, "CreateCampaign", 1, 5);
		String budgetedCost=flib.getCellData(EXEL_PATH, "CreateCampaign", 1, 6);
		String ExpectedResponse=flib.getCellData(EXEL_PATH, "CreateCampaign", 1, 7);
		String description=flib.getCellData(EXEL_PATH, "CreateCampaign", 1, 8);
		ccp.createCustomer(campaignName, startdate, expectedrevenue, actualCost, numsent, 
				endtdate, budgetedCost, ExpectedResponse, description);
		
		
		String campaigndetailTitle = flib.getCellData(EXEL_PATH, "CreateCampaign", 1, 9);
		wlib.verifyAssert(wlib.getPageTitle(), campaigndetailTitle, "campaign detail Page");
		
		
		zchp=new ZohoCRMHomePage(driver);
		zchp.clickCampaignlink();
		
		
		String ZohoCRMDisplayingCustomViewDetailsPageTitle = flib.getCellData(EXEL_PATH, "CreateCampaign", 1, 10);
		wlib.verifyAssert(wlib.getPageTitle(), ZohoCRMDisplayingCustomViewDetailsPageTitle, "campaign list Page");
		Thread.sleep(2000);
		
		zcdcvd=new ZohoCRMDisplayingCustomViewDetailsPage(driver);
		zcdcvd.clickDellCampaignlink();
		
		String CampaignDetailsTitle = flib.getCellData(EXEL_PATH, "CreateCampaign", 1, 9);
		wlib.verifyAssert(wlib.getPageTitle(), CampaignDetailsTitle, "campaign detail Page");
		
		cdp=new CampaignDetailsPage(driver);
		cdp.clickEditbtn();
		
		String EditCampaignPageTitle = flib.getCellData(EXEL_PATH, "CreateCampaign", 1, 11);
		wlib.verifyAssert(wlib.getPageTitle(), EditCampaignPageTitle, "Edit Campaign Page");
		
		
		ec=new EditCampaignPage(driver);
		ec.getCampaignnametb().clear();
		ec.setCampaignnametb(flib.getCellData(EXEL_PATH, "CreateCampaign", 2, 0));
		Thread.sleep(3000);
		
		ec.clickSavebtn();
		String CampaignDetailsTitle1 = flib.getCellData(EXEL_PATH, "CreateCampaign", 1, 9);
		
		wlib.verifyAssert(wlib.getPageTitle(), CampaignDetailsTitle1, "campaign detail Page after editing");
		
		
		zchp=new ZohoCRMHomePage(driver);
		zchp.clickCampaignlink();
		
		
		
		zcdcvd=new ZohoCRMDisplayingCustomViewDetailsPage(driver);
		List<WebElement>alllinks=zcdcvd.getCampaignList();
		
		int campaignListSize=alllinks.size();
		for (int i = 0; i < campaignListSize; i++) {
			WebElement link=alllinks.get(i);
			String text = alllinks.get(i).getText();
			if(text.equals(flib.getCellData(EXEL_PATH, "CreateCampaign", 2, 0))) {
				
				Reporter.log("edited campaign displayed",true);
				
				break;
			}
		}
		

	}
}
