package com.zoho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_AllContacts_Page {
	public Create_AllContacts_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//input[@class='button'])[3]")private WebElement newContact;
	public void clickNewContact() {
		newContact.click();
	}

}
