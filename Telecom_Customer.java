package com.nextgen.bean;



public class Telecom_Customer{
	private int customerId;
	private int callduration;
	private String datecall;
	
	public Telecom_Customer(int customerId, int callduration, String datecall) {
		this.customerId = customerId;
		this.callduration = callduration;
		this.datecall = datecall;
	}
	
	public Telecom_Customer() {
		
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCallduration() {
		return callduration;
	}

	public void setCallduration(int callduration) {
		this.callduration = callduration;
	}

	public String getDatecall() {
		return datecall;
	}

	public void setDatecall(String datecall) {
		this.datecall = datecall;
	}
	
}
