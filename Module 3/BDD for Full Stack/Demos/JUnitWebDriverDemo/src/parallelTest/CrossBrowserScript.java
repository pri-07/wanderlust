package parallelTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserScript
{
	WebDriver driver;
	
	
	@BeforeTest
	@Parameters("browser")
	public void setupTest(String browser) throws Exception
	{
		//Verify if parameter passed from TestNG is FireFox
		if(browser.equalsIgnoreCase("firefox"))
		{
		    //create FireFox instance
			driver = new FirefoxDriver();
		}		
		//Verify if parameter passed from TestNG is Chrome
		else if(browser.equalsIgnoreCase("chrome"))
		{
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver","C:/Advanced Selenium Libs/Drivers/chromedriver.exe");
			//create Chrome instance
			driver = new ChromeDriver();
		}
		//Verify if parameter passed from TestNG is IE
		else if(browser.equalsIgnoreCase("ie"))
		{
			//set path to IE.exe
			System.setProperty("webdriver.ie.driver","C:/Advanced Selenium Libs/Drivers/IEDriverServer.exe");
			//create IE instance
			driver = new InternetExplorerDriver();
		}
		else
		{
			//If no browser passed throw exception
			throw new Exception("No browser specified");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void RunCrossBrowserScript() throws InterruptedException
	{
		driver.get("http://demo.opencart.com/");		
	}
}