package com.cg.sms.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.sms.dto.Student;
import com.cg.sms.service.StudentService;
import com.cg.sms.service.StudentServiceImpl;

public class Main {
	
	public static void main(String[] args) 
	{
		//Student student=new Student();
		StudentService service=new StudentServiceImpl();
		
		Scanner sc=new Scanner(System.in);
		int ch=0;
		
		do{		
	
		System.out.println("1.Add Student");
		System.out.println("2.Display student details");
		System.out.println("3.Update details");
		System.out.println("4.Display student list");
		System.out.println("5.Exit");

		System.out.println("Enter your choice:");
		ch=sc.nextInt();
		
		switch(ch)
		{
		
		case 1: 
		System.out.println("Enter name:");
		String name=sc.next();
		

		System.out.println("Enter course name:");
		String cname=sc.next();
		

		System.out.println("Enter age:");
		int age=sc.nextInt();
		

		System.out.println("Enter mobile number:");
		String mob=sc.next();
		
		Student student=new Student();
		student.setName(name);
		student.setCourseName(cname);
		student.setAge(age);
		student.setMobileNo(mob);
		
		int rn=service.addStudent(student);
		System.out.println("Student record added:"+rn);
		break;
		
		case 2:
			System.out.println("Enter roll no:");
			rn=sc.nextInt();
			
			student=service.getStudent(rn);
			
			if(student==null)
			{
				System.out.println("Record not found . . . . ");
			}
			else
			{
				System.out.println(student.getName());
				System.out.println(student.getAge());
				System.out.println(student.getCourseName());
				System.out.println(student.getMobileNo());
			}
			break;
			
		case 3:
			System.out.println("Enter roll no:");
			rn=sc.nextInt();
			student=service.getStudent(rn);
			student=service.updateStudent(student);
					if(student==null)
					{
						System.out.println("Record not found . . . . ");
					}
					else
					{
						System.out.println("Enter new Mobile Number");
						String mobno=sc.next();
						student.setMobileNo(mobno);
						student=service.updateStudent(student);
						System.out.println("Record updated");
						
						System.out.println(student.getName());
						System.out.println(student.getMobileNo());
					}
					break;
					
		case 4:
			System.out.println("Enter course name");
			cname=sc.next();
			
			ArrayList<Student> list=service.getStudentList(cname);
			
			if(list.size()==0)
			{
				System.out.println("No student enrolled to course");
			}
			else
			{
				for(Student s:list)
				{
					System.out.println(s.getName()+" "+s.getMobileNo());
				}
			}
			break;
		
		}//end of switch
		
	}while(ch!=5); //end of do-while
	
	}
}