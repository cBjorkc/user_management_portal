package com.nextgen.service;

import java.util.List;

import com.nextgen.bean.Bill;
import com.nextgen.dao.OperatorDao;

public class OperatorService {
	
	public static List<Bill> getTotalUsage(int customerId, String activationDate) {
		
		OperatorDao dao = new OperatorDao();
		
		return dao.getTotalUsage(customerId, activationDate);
	}

}
