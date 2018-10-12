import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGWD01
{
	WebDriver driver;
	SoftAssert softAssert=new SoftAssert();
	
	@BeforeTest
	public  void openBrowser()
	{
		driver=new FirefoxDriver();

		driver.get("http://demo.opencart.com/");
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	
		String title=driver.getTitle();
		//Assert.assertEquals(title, "Your Store2");
		softAssert.assertEquals(title,"Your Store2");
	}
	
	@Test
	public  void testCaseOne() throws InterruptedException
	{
		
		WebElement searchBox=driver.findElement(By.name("search"));
		
		searchBox.sendKeys("Phone");
		
		Thread.sleep(5000);
		
		driver.findElement(By.className("input-group-btn")).click();
						
		Thread.sleep(5000);
		driver.quit();
	}

	@AfterTest
	public  void closeBrowser()
	{
		driver.quit();
	}
}