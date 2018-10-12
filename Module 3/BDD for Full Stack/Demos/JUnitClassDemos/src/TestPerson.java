import org.junit.*;
import static org.junit.Assert.*;

public class TestPerson
{
	Person P2 = new Person("Ray","Barone");
	//Person P3 = new Person();
	
	@Before
	public void DoBeforeTest()
	{
		System.out.println("One time initialization code before each test");
	}
	
	@After
	public void DoAfterTest()
	{
		System.out.println("One time cleanup code after each tests");
	}
	
	@BeforeClass
	public static void DoBeforeAllTest()
	{
		System.out.println("One time initialization code before all tests");
	}
	
	@AfterClass
	public static void DoAfterAllTest()
	{
		System.out.println("One time cleanup code after all tests");
	}
	
	@Test
	public void GetFullName()
	{
		assertEquals("Ray Barone",P2.getFullName());
	}
	
	@Test
	public void GetFirstName()
	{
		assertEquals(P2.getFirstName(),"Ray");
	}
	
	@Test
	public void GetLastName()
	{
		assertEquals(P2.getLastName(),"Barone");
	}
	
	@Test
	public void NullInName()
	{
		assertNotNull("Full name null",P2.getFullName());
		assertNotNull("First name null",P2.getFirstName());
		assertNotNull("Last name null",P2.getLastName());
		
	    //assertNotNull("Last name null",P3.getLastName());    
		
	}
}