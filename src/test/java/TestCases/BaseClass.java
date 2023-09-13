package TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
 
ReadConfig readconfig = new 	ReadConfig();
   public String baseURL=readconfig.getApplicationUrl();
   public String username=readconfig.getUserName();
   public String password=readconfig.getPassword();
   public static WebDriver driver;
   public static Logger logger;
   
   @Parameters("browser")
   @BeforeClass
   public void setup(String browserName)
   {
	   logger = LogManager.getLogger("BaseClass");
	   
	   if(browserName.equalsIgnoreCase("Chrome"))
	   {
		   WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
	   }
	   else if(browserName.equalsIgnoreCase("FireFox"))
	   {
		   WebDriverManager.firefoxdriver().setup();
		   driver=new FirefoxDriver();
	   }
	   else if(browserName.equalsIgnoreCase("IE"))
	   {
		   WebDriverManager.iedriver().setup();
		   driver=new InternetExplorerDriver();
	   }
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       driver.get(baseURL);
   }
   
   @AfterClass
   public void teardown()
   {
	   driver.quit();
   }
   
   public void captureScreen(WebDriver driver,String tname) throws IOException
   {
	   TakesScreenshot ts = (TakesScreenshot)driver;
	   File source = ts.getScreenshotAs(OutputType.FILE);
	   File target = new File (System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
	   FileUtils.copyFile(source, target);
	   System.out.println("Screenshot taken");
	   
   }
   
   
}



