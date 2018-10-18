package com.cg.mobshop.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.mobshop.dto.Mobile;
import com.cg.mobshop.dto.PurchaseDetails;
import com.cg.mobshop.exception.PurchaseException;
import com.cg.mobshop.service.PurchaseService;
import com.cg.mobshop.service.PurchaseServiceImpl;

public class Main 
{
	public static void main(String[] args) throws PurchaseException, SQLException, IOException 
	{
		PurchaseDetails pd=new PurchaseDetails();
		PurchaseService service=new PurchaseServiceImpl();
		
		//Mobile mobile=new Mobile();
		int ch;
		do
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("1.Add customer and purchase information.");
			System.out.println("2.Display list of mobiles");
			System.out.println("3.Display list based on price range");
			System.out.println("4.Update mobile details");
			System.out.println("Enter choice");
			
			ch=sc.nextInt();
			
			switch(ch)
			{
				case 1:
					do{
						
					System.out.println("Enter name:");
					String custName=sc.next();
					System.out.println("Enter email id:");
					String mailID=sc.next();
					System.out.println("Enter 10 digit contact number:");
					String phoneNo=sc.next();
					System.out.println("Enter desired 4 digit mobile id:");
					int mobileID=sc.nextInt();
					
					pd.setCustName(custName);
					pd.setMailID(mailID);
					pd.setPhoneNo(phoneNo);
					pd.setMobileID(mobileID);
					
					try
					{
						if(service.validateDetails(pd)!=null)
							break;
						else
							System.out.println("Invalid details");
						}
						catch(Exception e)
						{
							System.err.println(e.getMessage());
						}
					}
					while(true);
					
					int pid=service.addPurchaseDetails(pd);
					System.out.println("Purchase id is:"+pid);
					break;
					
				case 2:
					System.out.println("The list of available mobiles are:");
					ArrayList<Mobile> list=new ArrayList<Mobile>();
					list=service.getMobileList();
					if(list.size()==0)
					{
						System.out.println("No mobiles available");
					}
					else{
					
						for(Mobile m:list)
						{
							System.out.print(m.getMobileID()+" ");
							System.out.print(m.getName()+" ");
							System.out.print(m.getQuantity()+" ");
							System.out.println(m.getPrice()+" ");
						}
					}
					break;
					
				case 3:
					ArrayList<Mobile> list2=new ArrayList<Mobile>();
					System.out.println("Enter minimum price:");
					int min=sc.nextInt();
					System.out.println("Enter maximum price");
					int max=sc.nextInt();
					list2=service.getMobileList(min,max);
					if(list2.size()==0)
					{
						System.out.println("No mobiles available for given price range");
					}
					else{
					
						for(Mobile m:list2)
						{
							System.out.print(m.getMobileID()+" ");
							System.out.print(m.getName()+" ");
							System.out.print(m.getQuantity()+" ");
							System.out.println(m.getPrice()+" ");
						}
					}
					
				case 4:
					System.out.println("Enter mobile id");
					int mobID=sc.nextInt();
					System.out.println("Enter new price");
					double price=sc.nextDouble();
					System.out.println("Enter new quantity");
					int quantity=sc.nextInt();
					
					Mobile mobu=new Mobile();
					mobu.setMobileID(mobID);
					mobu.setPrice(price);
					mobu.setQuantity(quantity);
					
					mobu=service.updateMobileDetails(mobu);
					
					if(mobu!=null)
					System.out.println("Mobile details updated successfully");
					
			}
		
		
		}while(ch!=5);
		
		System.out.println("End of program");
			
	}
}
