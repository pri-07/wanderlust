package com.cg.mobshop.dto;

public class Mobile 
{
	int mobileID;
	String name;
	double price;
	int quantity;
	
	public int getMobileID() {
		return mobileID;
	}
	public void setMobileID(int i) {
		this.mobileID = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double d) {
		this.price = d;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
