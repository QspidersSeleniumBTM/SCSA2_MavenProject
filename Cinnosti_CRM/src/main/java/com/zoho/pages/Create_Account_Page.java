package com.zoho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Account_Page {
	public Create_Account_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//a[@class='menuOff'])[2]")private WebElement accountLink;
	public void clickAccount() throws Throwable {
		Thread.sleep(3000);
		accountLink.click();
	}
	@FindBy(name="property(Account Name)")private WebElement accountName;
	public void setAccountName(String AN) {
		accountName.sendKeys(AN);
	}
	@FindBy(xpath="(//input[@name='Button'])[1]")private WebElement save;
	public void clickSave() {
		save.click();
	}

}
