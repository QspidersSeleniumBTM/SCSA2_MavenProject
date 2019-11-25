package genericLib;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class WebDriverCommonLibraryCRM extends BaseTestCRM {
public String getPageTitle() {
	String pageTitle = driver.getTitle();
	return pageTitle;
	
}
public void waitForPageLoad(String title) {
	WebDriverWait wait=new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.titleContains(title));
	
}
public void waitForVisibilityOfElement(By locator) {
	WebDriverWait wait=new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	
}
public void selectOption(WebElement element,String text) {
	Select sel=new Select(element);
	sel.selectByVisibleText(text);
}
public void selectOption(WebElement element,int index) {
	Select sel=new Select(element);
	sel.selectByIndex(index);
}
public void selectOption(String value,WebElement element) {
	Select sel=new Select(element);
	sel.selectByValue(value);
}
public void mouseHover(WebElement target) {
	Actions ac=new Actions(driver);
	ac.moveToElement(target);
	}
public void verifyAssert(String actual,String expected,String message ) {
	Assert.assertEquals(actual, expected);
	Reporter.log(message+"is verified Passed", true);
}
public void verifySoftAssert(String actual,String expected,String message ) {
	SoftAssert sa=new SoftAssert();
	sa.assertEquals(actual, expected);
	Reporter.log(message+"is verified Passed", true);
}

public void newBrowserWindows(WebDriver driver) {
	Set<String> allwhs = driver.getWindowHandles();
	int noOfBrowserWindows = allwhs.size();
	for(String wh:allwhs) {
		
	}
	
}

}

