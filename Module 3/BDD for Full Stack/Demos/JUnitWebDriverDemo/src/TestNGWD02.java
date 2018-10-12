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

public class TestNGWD02
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
		
		Assert.assertEquals(title, "Your Store");
	}
	
	@Test
	public  void testCaseOne() throws InterruptedException
	{
		
		softAssert.assertTrue(false);
		
		WebElement searchBox=driver.findElement(By.name("search"));
		
		searchBox.sendKeys("Phone");
		
		Thread.sleep(5000);
		
		driver.findElement(By.className("input-group-btn")).click();
		
		Thread.sleep(5000);
		
		softAssert.assertEquals(driver.getTitle(), "Search - Phone2","Phone search failed");
		
		driver.findElement(By.id("input-search")).clear();
		
		driver.findElement(By.id("input-search")).sendKeys("Mac");
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("button-search")).click();
		
		Thread.sleep(5000);
		
		Assert.assertEquals(driver.getTitle(), "Search - Mac","Mac search failed");
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("input-search")).clear();
		
		driver.findElement(By.id("input-search")).sendKeys("Cameras");
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("button-search")).click();
		
		Thread.sleep(5000);
		
		softAssert.assertAll();
	}
	
	@AfterTest
	public  void closeBrowser()
	{
		driver.quit();
	}

}