package com.zoho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Potential_Page {
	public Create_Potential_Page(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[.='Potentials']")private WebElement potentialLink;
	public void clickPotential() {
		potentialLink.click();
	}
	@FindBy(name="property(Potential Name)")private WebElement potentialName;
	public void setPName(String nm) {
		potentialName.sendKeys(nm);
	}
	@FindBy(xpath="//img[@title='Account Name Lookup']")private WebElement ANLookUP;
	public void clickANLook() {
		ANLookUP.click();
	}
	@FindBy(xpath="//[@class='link']")private WebElement nextLink;
	public void clickNext() {
		nextLink.click();
	}
	@FindBy(xpath="//a[.='Next']") private WebElement accName;
	public void clickAName() {
		accName.click();
	}
	@FindBy(xpath="//img[@title='Calendar']")private WebElement calender;
	public void clickCalender() {
		calender.click();
	}
	@FindBy(xpath="//a[.='26']")private WebElement date;
	public void selectDate() {
		date.click();
	}
	@FindBy(name="property(Stage)")private WebElement stage;
	public void clickStage() {
		stage.click();
	}
	public WebElement getStage() {
		return stage;
	}
	@FindBy(xpath="(//input[@value='Save'])[1]")private WebElement save;
	public void clickSave() {
		save.click();
	}
	
	
	
	
	
}
