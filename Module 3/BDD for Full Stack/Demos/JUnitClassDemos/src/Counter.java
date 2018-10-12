
public class Counter 
{
	int count = 0;
	
	public int Increment()
	{
		return ++count;
	}
	
	public int Decrement()
	{
		return --count;
	}
	
	public int getCount()
	{
		return count;
	}
}
