package com.cg.parallel.service;

import com.cg.parallel.dao.PaymentDAOImpl;
import com.cg.parallel.dto.Payment;

public class PaymentServiceImpl implements PaymentService{

	PaymentDAOImpl dao;
	public PaymentServiceImpl()
	{
		dao=new PaymentDAOImpl();
	}
	@Override
	public String addDetails(Payment payment) {
		
		return dao.addDetails(payment);
	}

}
