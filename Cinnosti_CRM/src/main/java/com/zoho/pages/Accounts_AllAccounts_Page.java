package com.zoho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accounts_AllAccounts_Page {
	public Accounts_AllAccounts_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@value='New Account']")private WebElement newAccount;
	public void clickNewAccount() {
		newAccount.click();
	}

}
