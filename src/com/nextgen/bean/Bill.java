package com.nextgen.bean;

public class Bill {
	private int billId;
	private int customerId;
	private int month;
	private double fee;
	
	public Bill() {
	}

	public Bill(int billId, int customerId, int month, double fee) {
		super();
		this.billId = billId;
		this.customerId = customerId;
		this.month = month;
		this.fee = fee;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

}
