package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups = {"Regression","Master"})
	void verifyAccountRegistration() throws InterruptedException
	{
		try {
		logger.info("*** Starting TC001_AccoutRegistrationTest ***");
		
		/*
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		logger.info("*** Clicked on MyAccount link ***");
				
		hp.clickRegister();
		logger.info("*** clicked on Register Link ***");
		*/
		AccountRegistrationPage arp=new AccountRegistrationPage(driver);
		
		logger.info("*** Providing customer details ***");
		String fname=randomString();
		System.out.println("First Name:"+fname);
		arp.setFirstName(fname);
		
		String lname=randomString();
		System.out.println("Last Name:"+lname);
		arp.setLastName(lname);
		
		String email=randomString()+"@gmail.com";
		System.out.println("Email:"+email);
		arp.setEmail(email);
		
		String pword=randomAlphanumeric();
		System.out.println("Password:"+pword);
		arp.setPassword(pword);
		
		arp.setPrivacyPolicy();
		arp.clickContinue();
		
		logger.info("*** Validating expected message ***");
		System.out.println(arp.getConfirmationMsg());
		
		if(arp.getConfirmationMsg().equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed..");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(arp.getConfirmationMsg(),"Your Account Has Been Created!");	
		}
		catch (Exception e) 
		{
			Assert.fail();
		}
		
		
	}
	
	
}
