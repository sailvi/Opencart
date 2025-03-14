package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	{
		
		FileReader file=new FileReader("H:\\eclipse-workspace\\Opencart\\src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		switch(br.toLowerCase())
		{
			case "chrome":driver=new ChromeDriver();break;
			case "edge":driver=new EdgeDriver();break;
			case "firefox":driver=new FirefoxDriver();break;
			default:System.out.println("invalid browser name..");return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();
	}
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void teardown()
	{
		driver.quit();
	}
	public String getRandomString()
	{
		return RandomStringUtils.randomAlphabetic(6);
	}
	public String getRandomNumber()
	{
		return RandomStringUtils.randomAlphanumeric(10);
	}
	public String getAlphaNumeric()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		String generatedNumber=RandomStringUtils.randomAlphanumeric(3);
		return (generatedString+"@"+generatedNumber);
	}

}
