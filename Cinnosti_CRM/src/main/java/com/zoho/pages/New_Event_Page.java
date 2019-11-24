package com.zoho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class New_Event_Page {
	public  New_Event_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="subject")private WebElement subject;
	public void setSubject(String subj) {
		subject.sendKeys(subj);
	}
	@FindBy(xpath="//img[@src='/crm/images/cal.gif']")private WebElement calender;
	public void clickCalender() {
		calender.click();
	}
	@FindBy(xpath="//a[.='25']") private WebElement date;
	public void selectDate() {
		date.click();
	}
	@FindBy(xpath="(//input[@class='button'])[2]")private WebElement save;
	public void clickSvae() {
		save.click();
	}
	@FindBy(name="property(durationhrs)")private WebElement hourD;
	public WebElement getHour() {
		return hourD;
	}
	@FindBy(name="property(durationmins)")private WebElement minsD;
	public WebElement getMins() {
		return minsD;
	}
	@FindBy(id="time")private WebElement DT;
	public void setDT(String dt) {
		DT.sendKeys(dt);
	}
	
}
