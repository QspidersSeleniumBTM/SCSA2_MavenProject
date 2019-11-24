package com.zoho.genriclibraries;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zoho.pages.Create_Campaign_Page;

public class WebdriverGenericMethods extends BaseClass{

	Create_Campaign_Page cp = new Create_Campaign_Page(driver);
	public String getPageTitle()
	{
		String title=driver.getTitle();
		return title;
	}
	public void verifyAssert(String actual,String expected,String msg)
	{
		Assert.assertEquals(actual, expected);
		Reporter.log(msg+" is Displayed",true);
	}
	public void verifySoftAssert(String actual,String expected)
	{
		SoftAssert as=new SoftAssert();
		as.assertEquals(actual, expected);
		Reporter.log("Error message is displayed",true);
	}
	public void switchWindow(String wh)
	{
		driver.switchTo().window(wh);
	}
	public void selectOption(WebElement ddads,String text)
	{
		Select sel=new Select(ddads);
		sel.selectByVisibleText(text);
	}
	public void selectOption(WebElement ddads,int index)
	{
		Select sel=new Select(ddads);
		sel.selectByIndex(index);
	}
	public void selectOption(String value,WebElement ddads)
	{
		Select sel=new Select(ddads);
		sel.deselectByValue(value);
	}
}