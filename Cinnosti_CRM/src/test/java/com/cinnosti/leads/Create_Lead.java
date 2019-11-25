package com.cinnosti.leads;

import java.util.Set;

import org.testng.annotations.Test;

import com.zoho.genriclibraries.BaseClass;
import com.zoho.genriclibraries.File_Libraries;
import com.zoho.genriclibraries.WebdriverGenericMethods;
import com.zoho.pages.Create_Lead_Page;
import com.zoho.pages.Leads_AllOpen_Leads_Page;
//@Listeners(com.zoho.basics.MyListeners.class)
public class Create_Lead extends BaseClass{
	WebdriverGenericMethods wgm;
	Create_Lead_Page clp;
	File_Libraries flib = new File_Libraries();
	
	Leads_AllOpen_Leads_Page laol;
	@Test
	public void create_Lead() throws Throwable
	{
		wgm = new WebdriverGenericMethods();
		clp=new Create_Lead_Page(driver);
		laol=new Leads_AllOpen_Leads_Page(driver);
		clp.clickLead();
		String actual1=wgm.getPageTitle();
		String expected1=flib.getCellData(EXCEL_PATH, "Title", 17, 0);
		wgm.verifyAssert(actual1, expected1, "Leads Page");
		laol.clickNewLead();
		String newLeadWH=driver.getWindowHandle();
		String actual2=wgm.getPageTitle();
		String expected2=flib.getCellData(EXCEL_PATH, "Title", 19, 0);
		wgm.verifyAssert(actual2, expected2, "Create Lead Page");
		clp.clickFN();
		wgm.selectOption(clp.getFN(), 1);
		clp.setCompany(flib.getKeyPropVlaue(LEADS_PROPPATH, "company"));
		clp.setFN(flib.getKeyPropVlaue(LEADS_PROPPATH, "fname"));
		clp.setLN(flib.getKeyPropVlaue(LEADS_PROPPATH, "lname"));
		clp.clickCLN();
		Set<String> whs = driver.getWindowHandles();
		for(String wh:whs) { String title = driver.switchTo().window(wh).getTitle();
			if(!title.equals(actual2)) {
				clp.clickCampLookUP();
			}
		} wgm.switchWindow(newLeadWH);
		clp.clickSave();
		String actual3=wgm.getPageTitle();
		String expected3=flib.getCellData(EXCEL_PATH, "Title", 21, 0);
		wgm.verifyAssert(actual3, expected3, "Lead Details Page");
	}
	

}
