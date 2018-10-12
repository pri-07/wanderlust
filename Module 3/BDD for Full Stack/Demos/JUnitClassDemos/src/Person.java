public class Person 
{
	private String firstName;
	private String lastName;
	
	public Person(String FName, String LName)
	{
		if(FName==null && LName==null)
		{
			throw new IllegalArgumentException("Both names cannot be null");
		}
		
		this.firstName = FName;
		this.lastName = LName;
	}
	
	/*public Person() 
	{
		// TODO Auto-generated constructor stub
		System.out.println("Hello");
	}*/

	public String getFullName()
	{
		String first = (this.firstName !=null) ? this.firstName : "?";
		String last = (this.lastName !=null) ? this.lastName : "?";
		return first + " " + last;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public static void main(String args[])
	{
		Person p = new Person("A","B");
		System.out.println(p.getFirstName());
	}
}