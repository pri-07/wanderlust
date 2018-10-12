import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JUnitWD04
{
	WebDriver driver;
	
	@Before
	public  void openBrowser()
	{
		System.out.println("In Before");
		driver=new FirefoxDriver();

		driver.get("http://demo.opencart.com/");
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		String title=driver.getTitle();
		
		assertEquals("Your Store", title);
	}
	
	@Test
	public  void testCaseOne() throws InterruptedException
	{	
		
		WebElement searchBox=driver.findElement(By.name("search"));
		
		searchBox.sendKeys("Phone");
		
		Thread.sleep(5000);
		
		driver.findElement(By.className("input-group-btn")).click();
		
		Thread.sleep(5000);
		
		String searchText=driver.findElement(By.xpath("//*[@id='content']/h1")).getText();
		
		assertTrue(searchText.contains("Phone2"));
		
	}
	
	@Test
	public  void testCaseTwo() throws InterruptedException
	{
			
		WebElement searchBox=driver.findElement(By.name("search"));
		
		searchBox.sendKeys("Mac");
		
		Thread.sleep(5000);
		
		driver.findElement(By.className("input-group-btn")).click();
		
		Thread.sleep(5000);
		
		String searchText=driver.findElement(By.xpath("//*[@id='content']/h1")).getText();
		
		assertTrue(searchText.contains("Mac"));
		
	}
	
	@Test
	public  void testCaseThree() throws InterruptedException
	{
			
		WebElement searchBox=driver.findElement(By.name("search"));
		
		searchBox.sendKeys("Monitors");
		
		Thread.sleep(5000);
		
		driver.findElement(By.className("input-group-btn")).click();
		
		Thread.sleep(5000);
		
		String searchText=driver.findElement(By.xpath("//*[@id='content']/h1")).getText();
		
		assertTrue(searchText.contains("Monitor"));
		
	}
	
	@After
	public  void closeBrowser()
	{
		System.out.println("In After");
		driver.quit();
	}

}