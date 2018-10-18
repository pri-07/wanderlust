package com.cg.parallel.dao;

import java.util.ArrayList;

import com.cg.parallel.dto.Payment;

public class DataStore {

	static ArrayList<Payment> paymentlist;
	public static ArrayList<Payment> createCollection() {
		
		if(paymentlist==null)
		{
			paymentlist=new ArrayList<>();
		}
		
		return paymentlist;
		// TODO Auto-generated method stub
		
	}

}
