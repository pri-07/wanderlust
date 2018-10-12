import org.junit.*;
import static org.junit.Assert.*;

public class TestStudent
{
	
	Student S1=new Student(101, "Alexandra","Barone");
	
	@Test
	public void GetRollNo()
	{
		assertEquals(S1.getRollNo(),101);
	}
	
	@Test
	public void GetFirstName()
	{
		assertEquals(S1.getFirstName(),"Alexandra");
	}
	
	@Ignore("The method is being modified")
	@Test
	public void GetLastName()
	{
		assertEquals(S1.getLastName(),"Barone");
	}
}