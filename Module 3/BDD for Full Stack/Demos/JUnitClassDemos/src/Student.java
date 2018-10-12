public class Student
{
	int RollNo;
	String FirstName;
	String LastName;
	
	Student(int rollNo,String firstName,String lastName)
	{
		RollNo=rollNo;
		FirstName=firstName;
		LastName = lastName;
	}
	
	int getRollNo()
	{
		return RollNo;
	}
	
	String getFirstName()
	{
		return FirstName;
	}
	
	String getLastName()
	{
		return LastName;
	}
	
}