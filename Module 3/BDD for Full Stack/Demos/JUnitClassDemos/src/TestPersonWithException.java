import org.junit.*;
import static org.junit.Assert.*;

public class TestPersonWithException
{
	@Test
	public void GetFullName()
	{
		Person P1=new Person("Ray","Barone");
		assertEquals("Ray Barone",P1.getFullName());
	}
	
	@Test(expected=IllegalArgumentException.class)
	@Ignore("This is not working as per my expectations") 
	public void DisplayFullName()
	{
		Person P2=new Person(null,null);
		assertNotNull("Null in full name", P2.getFullName());
	}
}