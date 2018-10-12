import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitDriverDemo01
{

	public static void main(String[] args) throws InterruptedException
	{
			// Creating a new instance of the HTML unit driver
			WebDriver driver = new HtmlUnitDriver();
				
			driver.get("file:///D:/SeleniumWebDriverAT/Lesson05/src/AlertExample.html");         
		        
		    System.out.println("Page title is: " + driver.getTitle());      
		    Thread.sleep(10000);
		    driver.quit();
	}

}