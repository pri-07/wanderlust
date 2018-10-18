package com.cg.mobshop.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.mobshop.dto.Mobile;
import com.cg.mobshop.dto.PurchaseDetails;
import com.cg.mobshop.exception.PurchaseException;

public interface PurchaseService 
{
	public int addPurchaseDetails(PurchaseDetails pr) throws SQLException;
	public ArrayList<Mobile> getMobileList() throws SQLException;
	public ArrayList<Mobile> getMobileList(int min,int max) throws SQLException;
	public Mobile updateMobileDetails(Mobile mob) throws SQLException, PurchaseException;
	
	public PurchaseDetails validateDetails(PurchaseDetails pd) throws PurchaseException;
	public boolean validateName(String name);
	public boolean validatePhoneNo(String mob);
	public boolean validateEmail(String email);
}

