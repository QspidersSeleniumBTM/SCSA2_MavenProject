package com.zoho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Lead_Page {
	public Create_Lead_Page(WebDriver driver) {
	PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath="//a[.='Leads']")private WebElement leads;
	public void clickLead() {
		leads.click();
	}
	@FindBy(name="property(saltName)")private WebElement FNP;
	public void clickFN() {
		FNP.click();
	}
	public WebElement getFN() {
		return FNP;
	}
	@FindBy(name="property(Company)")private WebElement company;
	public void setCompany(String comp) {
		company.sendKeys(comp);
	}
	@FindBy(name="property(First Name)")private WebElement FN;
	public void setFN(String Fn) {
		FN.sendKeys(Fn);
	}
	@FindBy(name="property(Last Name)")private WebElement LN;
	public void setLN(String ln) {
		LN.sendKeys(ln);
	}
	@FindBy(xpath="//img[@title='Campaign Name Lookup']")private WebElement campNL;
	public void clickCLN() {
		campNL.click();
	}
	@FindBy(xpath="//a[.='WildCraft']") private WebElement camp;
	public void clickCampLookUP() {
		camp.click();
	}
	@FindBy(name="Button")private WebElement save;
	public void clickSave() {
		save.click();
	}
}
