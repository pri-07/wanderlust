package com.cg.mobshop.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.mobshop.exception.PurchaseException;

public class DBConnection {
	private static Connection con;
	public static Connection getConnection() throws IOException
	{
		String url="";			//can use prop file
		String username="";			//can use prop file
		String pwd="";				//can use prop file
		{
			try
			{
				if(con==null)
				{
					FileInputStream fis=new FileInputStream("./src/resources/dbconfig.properties");
					Properties prop=new Properties();
					
					prop.load(fis);
					
					url=prop.getProperty("url");
					String driver=prop.getProperty("driver");
					username=prop.getProperty("username");
					pwd=prop.getProperty("password");
				
					
					Class.forName(driver);     //can use prop file
					System.out.println("Class Loaded");
					con=DriverManager.getConnection(url,username,pwd);
					System.out.println("Connected to DB");

				}
				
				
			}
			catch(SQLException e)
			{
				try {
					throw new PurchaseException(e.getMessage());
				} catch (PurchaseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			catch(ClassNotFoundException e)
			{
				try {
					throw new PurchaseException(e.getMessage());
				} catch (PurchaseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		return con;	
	}
}
