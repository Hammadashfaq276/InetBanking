package TestCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import PageObject.AddCustomerPage;
import PageObject.LoginPage;

public class TC_Add_CustomerTest_003 extends BaseClass {
   
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.SetUsername(username);
		logger.info("User name is provided");
		lp.SetPassword(password);
		logger.info("password is provided");
		lp.SubmitBtn();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.AddNewCustomer();
		logger.info("Providing Customer details");
		addcust.custName("Hammad Ashfaq");
		addcust.custGender("male");
		addcust.custDob("10","15", "1992");
		Thread.sleep(5000);
		addcust.custaddress("Pakistan");
		addcust.custcity("Lahore");
		addcust.custstate("Punjab");
		addcust.custpin("34839298");
		addcust.custmobilenumber("828263262626");
		String email=randomstring() + "@gmail.com";
		addcust.custemail(email);
		addcust.custpassword("abcdef");
		addcust.custSubmit();
		Thread.sleep(5000);
		logger.info("validation started");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	public String randomstring()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}
	
	public static String randomNum()
	{
		String generatedstring2= RandomStringUtils.randomNumeric(4);
		return (generatedstring2);
	}
}
