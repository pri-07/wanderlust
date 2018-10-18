package com.cg.parallel.dao;

import java.util.ArrayList;

import com.cg.parallel.dto.Payment;

public class PaymentDAOImpl implements PaymentDAO{

	ArrayList<Payment> paymentlist;
	public PaymentDAOImpl()
	{
		paymentlist=DataStore.createCollection();
	}
	@Override
	public String addDetails(Payment payment) {
		return "Account created successfully";
	}

}
