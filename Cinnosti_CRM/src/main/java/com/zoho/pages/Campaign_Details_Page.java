package com.zoho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaign_Details_Page {
	public Campaign_Details_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@value='New Task']")private WebElement newTask;
	public void clickNewTask(){
		newTask.click();
	}
	@FindBy(name="event") private WebElement newEvent;
	public void clickEvent() {
		newEvent.click();
	}

}
