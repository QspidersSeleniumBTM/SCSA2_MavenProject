

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrackPage {

	@FindBy(id="logoutLink") private WebElement logoutLink;
	public WebElement getlogoutLink()
	{
		return logoutLink;
		
	}
	
	public void clicklogoutLink()
	{
		logoutLink.click();
	}
	
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
