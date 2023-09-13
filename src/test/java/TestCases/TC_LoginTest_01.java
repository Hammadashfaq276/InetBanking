package TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import PageObject.LoginPage;

public class TC_LoginTest_01 extends BaseClass {
 
	@Test
	public void LoginTest() throws IOException
	{
		
		logger.info("URL is Opened");
		LoginPage lp=new LoginPage(driver);
		
		lp.SetUsername(username);
		logger.info("Enter User Name");
		lp.SetPassword(password);
		logger.info("Enter Password");
		lp.SubmitBtn();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			
			Assert.assertTrue(true);
			logger.info("Test Case Passed");
		}
		else
		{
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("Test Case Failed");
		}
	}
	
}
