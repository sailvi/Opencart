package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccounRegistrationPage extends BasePage{

	public AccounRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkdPolicy;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setTelephone(String telephone)
	{
		txtTelephone.sendKeys(telephone);
	}
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
		
	}
	public void setConfirmPassword(String cnfpassword)
	{
		txtConfirmPassword.sendKeys(cnfpassword);
	}
	public void setPrivacyPolicy()
	{
		chkdPolicy.click();
	}
	public void clickContinue()
	{
		btnContinue.click();
	}
	public String getConfirmationMessage()
	{
		try
		{
			return (msgConfirmation.getText());
		}
		catch (Exception e) {
			// TODO: handle exception
			return (e.getMessage());
		}
		
	}
}
