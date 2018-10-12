import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class MultipleTestCaseExecutionDemo02 
{
	@Test(priority=0)
	public void c_test()
	{
		Assert.fail();
	}

	@Test(priority=7)
	public void a_test()
	{
		Assert.assertTrue(true);
	}
	
	@Test(priority=4)
	public void b_test()
	{
		throw new SkipException("Skipping b_test !!!");
	}
}
