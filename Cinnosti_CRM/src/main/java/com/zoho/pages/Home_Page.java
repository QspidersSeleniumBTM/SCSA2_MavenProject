package com.zoho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

	public  Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[.='Logout [rashmi@dell.com]']") private WebElement logout;
	public WebElement getLogout() {
		return logout;
	}
	public void clickLogout() {
		logout.click();
	}
	@FindBy(xpath="//td[.='Tasks List']") private WebElement homepage;
	public String getHomePage() {
		return homepage.getText();
	}
	@FindBy(xpath="//a[.='Campaigns']") private WebElement campaignlink;
	public void clickCampaign() {
		campaignlink.click();
	}
	@FindBy(id="Leadstab") private WebElement leadslink;
	public void clickLeads() {
		leadslink.click();
	}

}
