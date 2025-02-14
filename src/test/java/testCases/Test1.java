package testCases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
	WebDriver driver;
	
	@Test
	public void testMethod() throws InterruptedException
	{

		driver= new EdgeDriver();
		//driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://demo.opencart.com/");
		driver.get("https://tutorialsninja.com/demo/");
		Thread.sleep(5000);
		//driver.get("https://demo.opencart.com/en-gb?route=account/register");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//boolean dispStatus=driver.findElement(By.xpath("//span[normalize-space()='My Account']")).isDisplayed();
		//boolean enabStatus=driver.findElement(By.xpath("//span[normalize-space()='My Account']")).isEnabled();
		//WebElement myAc=driver.findElement(By.xpath("//body/nav/div/div[2]/ul/li[2]/div/a/span[text()='My Account']"));
		WebElement myAc=driver.findElement(By.xpath("//span[normalize-space()='My Account']"));
		//System.out.println(myAc.getText());
		myAc.click();
				
		
		//WebElement element = driver.findElement(By.xpath("//span[normalize-space()='My Account']"));
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		//System.out.println("Enable Status:"+enabStatus);
		//Assert.assertTrue(enabStatus);
		
		//driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("test");
	}
	

}
