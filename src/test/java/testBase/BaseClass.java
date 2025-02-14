package testBase;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@SuppressWarnings("deprecation")
	@BeforeClass(groups = {"Sanity","Regression","Master"})
	@Parameters({"OS","browser"})
	public void setup(String os,String br) throws IOException
	{
		logger=LogManager.getLogger(this.getClass());
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching OS");
				return;
			}
				
			switch(br.toLowerCase())
			{
			case "edge": capabilities.setBrowserName("MicrosoftEdge");break; 
			case "chrome": capabilities.setBrowserName("chrome");break;
			default:System.out.println("No matching browser");return;
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
			
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "edge":driver=new EdgeDriver();break;
			case "chrome":driver=new ChromeDriver();break;
			default:System.out.println("Invalid Browser Name..");return;
			}
		}
		
		//driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//driver.get("https://demo.opencart.com/");
		driver.get(p.getProperty("appURL2"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				
	}
	
	@AfterClass(groups = {"Sanity","Regression","Master"})
	public void tearDown()
	{
		//driver.quit();
	}
	
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(4);
		return(generatedString);
	}
	
	public String randomNumber()
	{
		String generatedNumber=RandomStringUtils.randomNumeric(4);
		return(generatedNumber);		
	}
	
	public String randomAlphanumeric()
	{
		@SuppressWarnings("deprecation")
		String generatedString=RandomStringUtils.randomAlphabetic(4);
		@SuppressWarnings("deprecation")
		String generatedNumber=RandomStringUtils.randomNumeric(4);
		String generatedAlphanumeric=generatedString+generatedNumber;
		return(generatedAlphanumeric);
	}
	
	public String captureScreen(String tname) throws IOException
	{
		//String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(LocalDateTime.now());
		
		// Get the current LocalDateTime
        LocalDateTime now = LocalDateTime.now();
        
        // Define the custom format pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd.HH.mm.ss");
        
        // Convert LocalDateTime to String using the formatter
        String timestamp = now.format(formatter);
        
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp;
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}
}
