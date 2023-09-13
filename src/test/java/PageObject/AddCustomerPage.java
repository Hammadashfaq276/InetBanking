package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
  
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(how = How.XPATH, using ="//body/div[3]/div[1]/ul[1]/li[2]/a[1]")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how = How.NAME,using = "name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how = How.NAME,using = "rad1")
	@CacheLookup
	WebElement rdGender;
	
	@CacheLookup
	@FindBy(how = How.ID_OR_NAME,using = "dob")
	WebElement txtdob;
	
	@CacheLookup
	@FindBy(how = How.NAME,using = "addr")
	WebElement txtaddress;
	
	@CacheLookup
	@FindBy(how = How.NAME,using = "city")
	WebElement txtcity;
	
	@CacheLookup
	@FindBy(how = How.NAME,using = "state")
	WebElement txtstate;
	
	@CacheLookup
	@FindBy(how = How.NAME,using = "pinno")
	WebElement txtpin;
	
	@CacheLookup
	@FindBy(how = How.NAME,using = "telephoneno")
	WebElement txtmobilenumber;
	
	@CacheLookup
	@FindBy(how = How.NAME,using = "emailid")
	WebElement txtemail;
	
	@CacheLookup
	@FindBy(how = How.NAME,using = "password")
	WebElement txtpassword;
	
	@CacheLookup
	@FindBy(how = How.NAME,using = "sub")
	WebElement btnSubmit;
	
	public void AddNewCustomer()
	{
		lnkAddNewCustomer.click();
	}
	
	public void custName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	}
	
	public void custGender(String cgender)
	{
		rdGender.click();
	}
	
	public void custDob(String mm,String dd,String yy)
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void custaddress(String caddress)
	{
		txtaddress.sendKeys(caddress);
	}
	
	public void custcity(String ccity)
	{
		txtcity.sendKeys(ccity);
	}
	
	public void custstate(String cstate)
	{
		txtstate.sendKeys(cstate);
	}
	
	public void custpin(String cpin)
	{
		txtpin.sendKeys(String.valueOf(cpin));
	}
	
	public void custmobilenumber(String cmn)
	{
		txtmobilenumber.sendKeys(cmn);
	}
	
	public void custemail(String cemail)
	{
		txtemail.sendKeys(cemail);
	}
	
	public void custpassword(String cpwd)
	{
		txtpassword.sendKeys(cpwd);
	}
	
	public void custSubmit()
	{
		btnSubmit.click();
	}
}
