package com.nextgen.demo;

import java.util.List;

import com.nextgen.bean.Bill;
import com.nextgen.service.OperatorService;

public class OperatorDemo {

	public static void main(String[] args) {
		
		
		int custId = 1;
		String activationDate = "2021-05-01";
		
		List<Bill> bills = OperatorService.getTotalUsage(custId, activationDate);
		
		int count = 0;
		System.out.println(count);
		for(Bill bill : bills) {
			
			System.out.println("billId: " + bill.getBillId() + " / custId: " + bill.getCustomerId() + " / Month: " + bill.getMonth() + " / Fee: " + bill.getFee());
			count++;
			System.out.println(count);
		}
		

	}

}
