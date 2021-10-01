package com.nextgen.demo;
import com.nextgen.bean.Telecom_Customer;
import com.nextgen.service.Telecom_CustomerService;
public class Telecom_CustomerDemo {
	public static void main(String[] args){
		Telecom_Customer customer1=new Telecom_Customer(1111,500,"2012-02-11");
		System.out.println("Customer registration");
		System.out.println(Telecom_CustomerService.registerCustomer(customer1));

}
}
