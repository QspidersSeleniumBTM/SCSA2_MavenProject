package com.zoho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Leads_AllOpen_Leads_Page {
	public Leads_AllOpen_Leads_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//input[@class='button'])[3]")private WebElement newLead;
	public void clickNewLead() {
		newLead.click();
	}

}
