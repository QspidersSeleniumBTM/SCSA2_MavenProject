package com.zoho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Potentials_AllPotentials {
 public Potentials_AllPotentials(WebDriver driver) {
PageFactory.initElements(driver, this);
}
 @FindBy(xpath="//input[@value='New Potential']")private WebElement newPotential;
 public void clickNewPotential() {
	 newPotential.click();
 }
}
