package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	 WebElement txtMyAccount;
	
	@FindBy(xpath ="//a[normalize-space()='Register']")
	WebElement txtRegister;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement linkLogin;
	
	public void clickMyAccount()
	{
		txtMyAccount.click();
	}
	
	public void clickRegister()
	{
		txtRegister.click();
		//Select myAcDropdown=new Select(txtMyAccount);
		
		//myAcDropdown.selectByVisibleText("Register");
	}
	
	public void clickLogin()
	{
		linkLogin.click();
	}
	
	}
