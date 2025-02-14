package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

 
public class AccountRegistrationPage {

	WebDriver driver;

	public AccountRegistrationPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	//@FindBy(xpath="//input[@id='input-firstname']")
	//WebElement txtFirstName;
	
	By txtFirstName=By.xpath("//input[@id='input-firstname']");
	
	//@FindBy(xpath = "//input[@id='input-lastname']")
	//WebElement txtLastName;
	By txtLastName=By.xpath("//input[@id='input-lastname']");
	
	//@FindBy(xpath = "//input[@id='input-email']")
	//WebElement txtEmail;
	By txtEmail=By.xpath("//input[@id='input-email']");
	
	//@FindBy(xpath = "//input[@id='input-password']")
	//WebElement txtPassword;
	By txtPassword=By.xpath("//input[@id='input-password']");
	
	//@FindBy(xpath = "//input[@name='agree']")
	//WebElement chkdPolicy;
	By chkdPolicy=By.xpath("//input[@name='agree']");
	
	//@FindBy(xpath = "//button[normalize-space()='Continue']")
	//WebElement btnContinue;
	//By btnContinue=By.xpath("//button[normalize-space()='Continue']");
	By btnContinue=By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[1]/form[1]/div[1]/button[1]");
	
	
	//@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	//WebElement msgConfirmation;
	By msgConfirmation=By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");
	
	public void setFirstName(String fname)
	{
		
		driver.findElement(txtFirstName).sendKeys(fname);
		
	}
	
	public void setLastName(String lname)
	{
		//txtLastName.sendKeys(lname);
		driver.findElement(txtLastName).sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		//txtEmail.sendKeys(email);
		driver.findElement(txtEmail).sendKeys(email);
	}
	public void setPassword(String pword)
	{
		//txtPassword.sendKeys(pword);
		driver.findElement(txtPassword).sendKeys(pword);
	}
	
	public void setPrivacyPolicy() throws InterruptedException
	{
		//chkdPolicy.click();
		//driver.findElement(chkdPolicy).click();
		WebElement setP=driver.findElement(chkdPolicy);
		Actions act=new Actions(driver);
		act.moveToElement(setP).click().perform();
		Thread.sleep(5000);
	}
	
	public void clickContinue() throws InterruptedException
	{
		//btnContinue.click();
		WebElement btnelement=driver.findElement(btnContinue);
		Actions act=new Actions(driver);
		act.moveToElement(btnelement).click().perform();
		Thread.sleep(5000);
		
	}
	
	public String getConfirmationMsg()
	{
		WebElement msgConf=driver.findElement(msgConfirmation);
		try {
			return msgConf.getText();
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
}
