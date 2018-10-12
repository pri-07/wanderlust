import org.junit.*;
import static org.junit.Assert.*;

public class TestCounter
{
	Counter counter1 = new Counter();
	
	@Test
	public void Increment()
	{
		assertTrue(counter1.Increment()==1);
		assertTrue(counter1.Increment()==2);
	}
	
	@Test
	public void Decrement()
	{
		assertTrue(counter1.Decrement()==-1);
	}
	
}