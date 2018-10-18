package com.cg.mobshop.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.mobshop.dto.Mobile;
import com.cg.mobshop.dto.PurchaseDetails;
import com.cg.mobshop.exception.PurchaseException;

public class PurchaseDAOImpl implements PurchaseDAO
{
	
	Connection connection;
	public PurchaseDAOImpl() throws PurchaseException, IOException
	{
		connection=DBConnection.getConnection();
	}
	
	public int generateId()
	{
		int id=0;
		try{
			
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery("select id_gen.nextval from dual");
			if(rs.next())
			{
				id=rs.getInt(1);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return id;
		
	}
	@Override
	public int addPurchaseDetails(PurchaseDetails pr) throws SQLException 
	{
		String sql="insert into purchasedetails values "+ "(?,?,?,?,sysdate,?)"; 
		
			PreparedStatement ps=connection.prepareStatement(sql);
			int id=generateId();
			ps.setInt(1,id);
			ps.setString(2,pr.getCustName());
			ps.setString(3,pr.getMailID());
			ps.setString(4,pr.getPhoneNo());
			ps.setInt(5,pr.getMobileID());
			
			int rowcount=ps.executeUpdate();
			if(rowcount==1)
				return id;

		return 0;

	}	
	@Override
	public ArrayList<Mobile> getMobileList() throws SQLException {
		
		ArrayList<Mobile> list=new ArrayList<Mobile>(); 
		String sql="select * from mobiles";
		Statement st=connection.createStatement();
		ResultSet rs=st.executeQuery(sql);
		
		while(rs.next())
		{
			Mobile mob=new Mobile();
			mob.setMobileID(rs.getInt("mobileid"));
			mob.setName(rs.getString("name"));
			mob.setPrice(rs.getDouble("price"));
			mob.setQuantity(rs.getInt("quantity"));
			
			list.add(mob);
			
		}
		return list;
	}

	@Override
	public ArrayList<Mobile> getMobileList(int min, int max) throws SQLException {
		ArrayList<Mobile> list=new ArrayList<Mobile>(); 
		
		String sql="select * from mobiles where price between "+ min +" and "+ max ; 
		Statement st=connection.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			Mobile mob=new Mobile();
			mob.setMobileID(rs.getInt("mobileid"));
			mob.setName(rs.getString("name"));
			mob.setPrice(rs.getDouble("price"));
			mob.setQuantity(rs.getInt("quantity"));
			
			list.add(mob);
			
		}
		return list;
	}

	@Override
	public Mobile updateMobileDetails(Mobile mob) throws SQLException, PurchaseException {
		String sql=" update mobiles "+" set price=?, "+" quantity=? where mobileId=? ";
		PreparedStatement ps=connection.prepareStatement(sql);
		
		ps.setDouble(1,mob.getPrice());
		ps.setInt(2,mob.getQuantity());
		ps.setInt(3,mob.getMobileID());
		
		int rowcount=ps.executeUpdate();
		
		if(rowcount==0)
			throw new PurchaseException("Mobile id invalid");
		
		return mob;
	}



}
