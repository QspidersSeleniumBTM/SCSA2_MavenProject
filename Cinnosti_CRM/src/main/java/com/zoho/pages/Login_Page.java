package com.zoho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	public Login_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="userName") private WebElement untb;
	public WebElement getUntb() {
		return untb;
	}
	public void setUntb(String un) {
		untb.sendKeys(un);
	}
	@FindBy(id="passWord") private WebElement pwtb;
	public WebElement getPwtb() {
		return pwtb;
	}
	public void setPwtb(String pw) {
		pwtb.sendKeys(pw);
	}
	@FindBy(xpath = "//input[@type='image']") private WebElement login;
	public WebElement getLogin() {
		return login;
	}
	public void clickLogin() {
		login.click();
	}
	public void login(String username,String password) throws Throwable {
		untb.sendKeys(username);
		pwtb.sendKeys(password);
		login.click();
		Thread.sleep(2000);
	}
	@FindBy(xpath="//td[@class='small mandatory']") private WebElement errmsg;
	public String geterrmsg() {
		return errmsg.getText();
	}
}
