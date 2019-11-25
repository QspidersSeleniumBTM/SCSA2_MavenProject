package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMLoginPage {
@FindBy(id="userName") private WebElement untb;
public WebElement getUntb() {
	return untb;
}
public void setUntb(String un) {
	untb.sendKeys(un);
}
@FindBy(id="passWord")private WebElement pwdtb;
public WebElement getPwdtb() {
	return pwdtb;
}
public void setPwdtb(String pwd) {
	pwdtb.sendKeys(pwd);
}
@FindBy(xpath="//input[@title='Sign In']")private WebElement loginbtn;

public void clickLoginbtn() {
	loginbtn.click();;
}
@FindBy (xpath="//td[@class='small mandatory']") private WebElement errorMsg;
public WebElement getErrorMsg() {
	return errorMsg;
	
}
public String setErrorMsg() {
	return errorMsg.getText();
	
	
}
public void login(String un,String pwd) throws Throwable {
	untb.sendKeys(un);
	pwdtb.sendKeys(pwd);
	loginbtn.click();
	Thread.sleep(2000);
}
public CRMLoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

}
