package testCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass
{
	@Test(groups= {"Sanity","Master"})
	public void verify_Login()
	{
		logger.info("*******TC002_LoginTest*********");
		try
		{
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("click MyAccount......");
			hp.clickLogin();
			logger.info("click login......");
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			MyAccountPage accPage=new MyAccountPage(driver);
			//String loginMsg=lp.validateLogin();
			Assert.assertEquals(accPage.isMyAccountPageExist(),true);
		}
		catch (Exception e) {
			// TODO: handle exception
			logger.info(e.getMessage());
			logger.info("Test failed......");
			Assert.fail();
		
		}
	}

}
