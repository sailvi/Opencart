package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{

	//My Account
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public boolean isMyAccountPageExist()
	{
		try
		{
			return msgHeading.isDisplayed();
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
