package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver ldriver;
    
    public LoginPage(WebDriver rdriver)
    {
    	ldriver=rdriver;
    	PageFactory.initElements(rdriver, this);
    }
    
    @FindBy(name="uid")
    @CacheLookup
    WebElement txtUserName;
    
    @FindBy(name="password")
    @CacheLookup
    WebElement txtpassword;
    
    @FindBy(name="btnLogin")
    @CacheLookup
    WebElement BtnLogin;
    
    @FindBy(xpath="//body/div[3]/div[1]/ul[1]/li[15]/a[1]")
    @CacheLookup
    WebElement lnkLogout;
    
    public void SetUsername(String uname)
    {
    	txtUserName.sendKeys(uname);
    }
    
    public void SetPassword(String pwd)
    {
    	txtpassword.sendKeys(pwd);
    }
    
    public void SubmitBtn()
    {
    	BtnLogin.click();
    }
    
    public void clickLogout()
    {
    	lnkLogout.click();
    }
}
