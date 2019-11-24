package com.zoho.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Product_Page {
public Create_Product_Page(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//a[.='Products']")private WebElement productsLink;
public void clickProducts() {
	productsLink.click();
}
@FindBy(xpath="//input[@value='New Product']")private WebElement newProduct;
public void clickNewProduct() {
	newProduct.click();
}
@FindBy(name="property(Product Name)")private WebElement PN;
public void setPName(String pn) {
	PN.sendKeys(pn);
}
@FindBy(xpath="(//input[@value='Save'])[1]")private WebElement save;
public void clickSave() {
	save.click();
}
}
