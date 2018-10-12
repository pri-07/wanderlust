import org.junit.*;
import static org.junit.Assert.*;

public class TestGreeting
{
	@Test
	public void TestGreet()
	{
		Greeting greet = new Greeting();
		
		assertEquals("Unexpected Result","Welcome to Java",greet.Greet());
	}
}
