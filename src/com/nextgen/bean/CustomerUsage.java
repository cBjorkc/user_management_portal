package com.nextgen.bean;

public class CustomerUsage {
	private int customerRegistrationId, callSec,dataKb;
	private String date;
	
	public int getCustomerRegistrationId() {
		return customerRegistrationId;
	}
	public void setCustomerRegistrationId(int customerRegistrationId) {
		this.customerRegistrationId = customerRegistrationId;
	}
	public int getCallSec() {
		return callSec;
	}
	public void setCallSec(int callSec) {
		this.callSec = callSec;
	}
	public int getDataKb() {
		return dataKb;
	}
	public void setDataKb(int dataKb) {
		this.dataKb = dataKb;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public CustomerUsage(int customerRegistrationId, int callSec, int dataKb, String date) {
		this.customerRegistrationId = customerRegistrationId;
		this.callSec = callSec;
		this.dataKb = dataKb;
		this.date = date;
	}
	
	public CustomerUsage() {
	}
	
	
}