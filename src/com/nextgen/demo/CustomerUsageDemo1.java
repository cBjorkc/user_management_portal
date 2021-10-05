package com.nextgen.demo;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import com.nextgen.bean.CustomerUsage;
import com.nextgen.dao.CustomerUsageDAO;



public class CustomerUsageDemo1 {
	
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
					
		String answer =" ";
		Scanner sc = new Scanner(System.in);
		List<CustomerUsage> matching;
		
		try {
			while (!answer.equals("")) {
				System.out.println("Would you like to view your usage details? Please enter 'search' or press enter to exit");
			    answer = sc.nextLine();
			    
			    if (answer.toLowerCase().equals("search")){
			    	System.out.println("Please enter customer ID:");
			    	answer = sc.nextLine();
			    	System.out.println("Show Usage details for customer registration ID "+answer);
			    	CustomerUsageDAO dao = new CustomerUsageDAO();
			    	matching = dao.selectCustomer(Integer.parseInt(answer));
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
				sc.close();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Data not inserted in correct format, exiting service.");
			System.exit(0);
		}
			}
			
}