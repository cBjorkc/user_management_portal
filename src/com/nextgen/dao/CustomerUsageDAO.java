   
package com.nextgen.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nextgen.bean.CustomerUsage;

public class CustomerUsageDAO {

	public static final String JDBC_URL = "jdbc:derby:C:\\Users\\2072308\\MyDB;create=true";
	public static final String USERNAME="test";
	public static final String PASSWORD="test";
	
	public Connection con=null;
	public ResultSet rs=null;
	
public boolean insertUsageData(CustomerUsage usg){
		
		try{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection con= DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			
			String insertQuery="insert into tbl_cust_usg values(?,?,?,?)";
			PreparedStatement ps= con.prepareStatement(insertQuery);
			
			ps.setInt(1,usg.getCustomerRegistrationId());
			ps.setInt(2, usg.getCallSec());
			ps.setInt(3, usg.getDataKb());
			ps.setString(4,usg.getDate());
			
			int count=ps.executeUpdate();
			
			if(count>0){
				return true;
			}
			
		}
		catch(ClassNotFoundException | SQLException e){
			System.out.println(e.getMessage());
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}	
		}
		}
		return false;
		
	}

	public List<CustomerUsage> selectCustomer(int custId){
		
		List<CustomerUsage> custUsg = new ArrayList<CustomerUsage>();
		
		try{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection con= DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			
			String selectQuery="select * from tbl_cust_usg where tbl_cust_usg.custId =?";
			PreparedStatement ps= con.prepareStatement(selectQuery);
			
			ps.setInt(1, custId);
			rs=ps.executeQuery();
			
			while(rs.next()){
				CustomerUsage customerUsage = new CustomerUsage(rs.getInt("CUSTID"),rs.getInt("CALLSEC"),
						rs.getInt("DATAKB"),rs.getString("DATE"));
				
				custUsg.add(customerUsage);
				
				
			}
			
		}
		catch(ClassNotFoundException | SQLException e){
			System.out.println(e.getMessage());
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			
		}
		}
		
		return custUsg;
		
	}
	
}