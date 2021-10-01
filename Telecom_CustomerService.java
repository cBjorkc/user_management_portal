package com.nextgen.service;



import com.nextgen.bean.Telecom_Customer;
import com.nextgen.dao.Telecom_CustomerDao;

public class Telecom_CustomerService {
	public static boolean registerCustomer(Telecom_Customer customer){
		Telecom_CustomerDao dao= new Telecom_CustomerDao();
		
		return dao.registerCustomer(customer);
	}
	
	

}
