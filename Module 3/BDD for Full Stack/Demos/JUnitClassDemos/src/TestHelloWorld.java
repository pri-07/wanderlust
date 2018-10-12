import org.junit.Test;
import static org.junit.Assert.*;

public class TestHelloWorld
{
	@Test
	public void TestSayHello()
	{
		HelloWorld hello = new HelloWorld();
		assertEquals("Hello World!", hello.SayHello());
	}
}
