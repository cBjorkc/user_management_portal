package com.nextgen.demo;

import java.util.List;
import java.util.ArrayList;

import com.nextgen.bean.CustomerUsage;
import com.nextgen.dao.CustomerUsageDAO;

// create this table beforehand, as it's supposed to exist already)
// create table TBL_CUST_USG(CUSTID int, CALLSEC int, DATAKB int, DATE date)


public class CustomerUsageDemo {
	
	public static void main(String[] args) {
		
		List<CustomerUsage> newUsgData = new ArrayList<CustomerUsage>();
		CustomerUsage usg1 = new CustomerUsage(123,365,2300,"2021-10-01");
		newUsgData.add(usg1);
		CustomerUsage usg2 = new CustomerUsage(123,1800,23450,"2019-05-01");
		newUsgData.add(usg2);
		CustomerUsage usg3 = new CustomerUsage(558,1250,20,"2021-03-12");
		newUsgData.add(usg3);
		
		
		for(CustomerUsage cu :newUsgData){
			CustomerUsageDAO dao = new CustomerUsageDAO();
			System.out.println(dao.insertUsageData(cu));
		}
			
		
		System.out.println("Looking for customer Usage Data with customer registration ID 123");
		CustomerUsageDAO dao = new CustomerUsageDAO();
		List<CustomerUsage> matching = dao.selectCustomer(123);
		
		if(matching.size()>0){
			System.out.println("REGID \t CALLSEC \t DATAKB \t DATE");
			for(CustomerUsage cu: matching){
				System.out.println(cu.getCustomerRegistrationId()+"\t"+
			cu.getCallSec()+"\t\t"+cu.getDataKb()+"\t\t"+ cu.getDate());
			}
		} else {
			System.out.println("No customers with specific ID found");
		}
		}
	

}
