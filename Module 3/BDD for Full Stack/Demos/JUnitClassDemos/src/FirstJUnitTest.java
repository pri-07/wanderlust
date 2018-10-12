import org.junit.Test;
import static org.junit.Assert.*;

public class FirstJUnitTest
{
	@Test
	public void SimpleAdd()
	{
		int Result = 1;
		int Expected =1;
		
		assertEquals(Expected, Result);
	}
}
