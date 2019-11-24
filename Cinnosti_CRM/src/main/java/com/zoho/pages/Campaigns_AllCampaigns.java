package com.zoho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaigns_AllCampaigns {
	public Campaigns_AllCampaigns(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@class='button'])[3]") private WebElement newCampaign;
	public WebElement getCampLink()
	{
		return newCampaign;
	}
	@FindBy(xpath="(//a[@class='link'])[13]")private WebElement campaign;
	public void selectCampaign() {
		campaign.click();
	}
	

}
