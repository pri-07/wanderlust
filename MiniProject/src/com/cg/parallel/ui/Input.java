package com.cg.parallel.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.parallel.dto.Payment;
import com.cg.parallel.service.PaymentService;
import com.cg.parallel.service.PaymentServiceImpl;


public class Input {
	
	public static void main(String[] args) 
	{
		
		PaymentService service=new PaymentServiceImpl();
		Scanner sc=new Scanner(System.in);
		int ch=0;
		
		do{		
	
			System.out.println("*******************************");
			System.out.println("1.Create Account");
			System.out.println("2.Display balance");
//			System.out.println("3.Update details");
//			System.out.println("4.Display student list");
//			System.out.println("5.Delete student record");
//			System.out.println("6.Exit");

			System.out.println("Enter your choice:");
			ch=sc.nextInt();
		
		switch(ch)
		{
		
		case 1: 
		System.out.println("Enter first name:");
		String fname=sc.next();
		
		System.out.println("Enter last name:");
		String lname=sc.next();
		

		System.out.println("Enter age:");
		int age=sc.nextInt();
		
		System.out.println("email");
		String email=sc.next();
		
		System.out.println("Enter mobile number:");
		String mobileno=sc.next();
		
		System.out.println("Enter password");
		String pwd=sc.next();
		
		Payment payment=new Payment();
		payment.setFname(fname);
		payment.setLname(lname);
		payment.setAge(age);
		payment.setEmail(email);
		payment.setMobileno(mobileno);
		payment.setPwd(pwd);
		
		String reply=service.addDetails(payment);
		System.out.println(reply);
		break;
		
		case 2:
			System.out.println("Enter email id:");
			email=sc.next();
			
			System.out.println("Enter password:");
			pwd=sc.next();
			
			break;
//			
//		case 3:
//			System.out.println("Enter roll no:");
//			rn=sc.nextInt();
//			student=service.getStudent(rn);
//					if(student==null)
//					{
//						System.out.println("Record not found . . . . ");
//					}
//					else
//					{
//						System.out.println("Enter new Mobile Number");
//						String mobno=sc.next();
//						student.setMobileNo(mobno);
//						student=service.updateStudent(student);
//						System.out.println("Record updated");
//						
//						System.out.println(student.getName());
//						System.out.println(student.getMobileNo());
//					}
//					break;
//					
//		case 4:
//			System.out.println("Enter course name");
//			cname=sc.next();
//			
//			ArrayList<Student> list=service.getStudentList(cname);
//			
//			if(list.size()==0)
//			{
//				System.out.println("No student enrolled to course");
//			}
//			else
//			{
//				for(Student s:list)
//				{
//					System.out.println(s.getName()+" "+s.getMobileNo());
//				}
//			}
//			break;
		
		}//end of switch
		
	}while(ch!=7); //end of do-while
		System.out.println("End of application");
	
	}
}