package com.zoho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class New_Task_Page {
	public  New_Task_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="subject")private WebElement subject;
	public void enterSubject(String subj) {
		subject.sendKeys(subj);
	}
	@FindBy(xpath="//img[@src='/crm/images/cal.gif']")private WebElement calender;
	public void clickCalender() {
		 calender.click();;
	}
	@FindBy(xpath="//a[.='15']")private WebElement date;
	public void selectDate() {
		date.click();
	}
	@FindBy(name="property(status)")private WebElement status;
	public void clickStatus() {
		status.click();
	}
	public WebElement getStatusDDads() {
		return status;
	}
	@FindBy(name="property(priority)")private WebElement priority;
	public void clickPriority() {
		priority.click();
	}
	public WebElement getPriorityDDads() {
		return priority;
	}
	@FindBy(xpath="(//input[@class='button'])[2]")private WebElement save;
	public void clickSave() {
		save.click();
	}
}
