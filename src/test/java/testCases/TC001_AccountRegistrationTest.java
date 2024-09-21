package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccounRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass
{
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("****TC001_AccountRegistrationTest****");
		try 
		{
			HomePage hp=new HomePage(driver);
			logger.info("click on Account...");
			hp.clickMyAccount();
			logger.info("click on Register...");
			hp.clickRegister();
			AccounRegistrationPage RegPage=new AccounRegistrationPage(driver);
			logger.info("Providing customer details...");
			RegPage.setFirstName(getRandomString().toUpperCase());
			RegPage.setLastName(getRandomString().toUpperCase());
			RegPage.setEmail(getRandomString()+"@gmail.com");
			RegPage.setTelephone(getRandomNumber());
			String password=getAlphaNumeric();
			RegPage.setPassword(password);
			RegPage.setConfirmPassword(password);
			RegPage.setPrivacyPolicy();
			logger.info("clock on Continue...");
			RegPage.clickContinue();
			String confirmMsg=RegPage.getConfirmationMessage();
			logger.info("validating expected message...");
			Assert.assertEquals(confirmMsg,"Your Account Has Been Created!");
		}
		catch (Exception e) {
			// TODO: handle exception
			logger.info("Test failed..");
			logger.debug("Debug logs..");
			Assert.fail();
		}

		logger.info("Finished TC001_AccountRegistrationTest...");
	}
	
}
