package com.zoho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Campaign_Page {
	
	public Create_Campaign_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
 @FindBy(name="property(Campaign Name)") private WebElement createCamp;
 public void setCampName(String name)  {
	 createCamp.sendKeys(name);
 }
 @FindBy(xpath="//img[@src='/crm/images/cal.gif']") private WebElement calender1;
 public void startDate() {
	 calender1.click();
 }
 @FindBy(xpath="(//img[@src='/crm/images/cal.gif'])[2]")private WebElement calender2;
 public void endDate()
 {
	 calender2.click();
 }
 @FindBy(xpath="//a[.='25']") private WebElement sDate;
 public void selectSDate() {
	 sDate.click();
 }
 @FindBy(xpath="//a[.='30']")private WebElement eDate;
 public void selectEDate()
 {
	 eDate.click();
 }
 @FindBy(name="property(Actual Cost)")private WebElement actualCost;
 public void setACost(String amt) {
	 actualCost.sendKeys(amt);
 }
 @FindBy(name="property(Num sent)")private WebElement mailsent;
 public void setMail(String ms) {
	 mailsent.sendKeys(ms);
 }
 @FindBy(name="property(Budgeted Cost)")private WebElement budgetedcost;
 public void budgetedCost(String bc) {
	 budgetedcost.sendKeys(bc);
 }
 @FindBy(name="property(Expected Revenue)")private WebElement eCost;
 public void expectedRevenue(String ec) {
	 eCost.sendKeys(ec);
 }
 @FindBy(name="property(Expected Response)")private WebElement eResop;
 public void eResponse(String er) {
	 eResop.sendKeys(er);
 }
 @FindBy(name="property(Type)")private WebElement type;
 public WebElement getTypeDD() {
	 return type;
 }
 @FindBy(name="property(Status)")private WebElement status;
 public WebElement getStatusDD()
 {
	 return status;
 }
 @FindBy(xpath="(//input[@name='Button'])[1]")private WebElement save;
 public void clickSave() {
	 save.click();
 }
}
