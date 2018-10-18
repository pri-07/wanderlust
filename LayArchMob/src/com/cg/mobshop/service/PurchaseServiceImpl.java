package com.cg.mobshop.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.mobshop.dao.PurchaseDAO;
import com.cg.mobshop.dao.PurchaseDAOImpl;
import com.cg.mobshop.dto.Mobile;
import com.cg.mobshop.dto.PurchaseDetails;
import com.cg.mobshop.exception.PurchaseException;

public class PurchaseServiceImpl implements PurchaseService
{
	
	PurchaseDAO dao;
	public PurchaseServiceImpl() throws PurchaseException, IOException
	{
		
			dao=new PurchaseDAOImpl();
	}
	@Override
	public int addPurchaseDetails(PurchaseDetails pr) throws SQLException {
		int pid=dao.addPurchaseDetails(pr);
		return pid;
	
	}

	@Override
	public ArrayList<Mobile> getMobileList() throws SQLException {
		
		return dao.getMobileList();
	}
	@Override
	public ArrayList<Mobile> getMobileList(int min, int max) throws SQLException {
		
		return dao.getMobileList(min,max);
	}
	@Override
	public Mobile updateMobileDetails(Mobile mob) throws SQLException, PurchaseException {
		
		return dao.updateMobileDetails(mob);
	}
	
	
	//Validation
	@Override
	public  PurchaseDetails validateDetails(PurchaseDetails pd)	throws PurchaseException {
		if( (validateEmail(pd.getMailID())) && (validateName(pd.getCustName())) && (validatePhoneNo(pd.getPhoneNo())))
			return pd;
		else
			return null;
		}
	
		@Override
		public boolean validateName(String name) {
			Pattern pat=Pattern.compile("[A-Z][a-z]{3,12}");
			Matcher mat=pat.matcher(name);
			return mat.matches();
	}
		@Override
		public boolean validatePhoneNo(String mob) {
			Pattern pat=Pattern.compile("[0-9]{10}");
			Matcher mat=pat.matcher(mob);
			return mat.matches();
		}
		@Override
		public boolean validateEmail(String email) {
			Pattern pat=Pattern.compile("[A-Za-z0-9]{2,15}@capgemini.com");
			Matcher mat=pat.matcher(email);
			return mat.matches();
		}
	

}
