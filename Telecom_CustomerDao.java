package com.nextgen.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nextgen.bean.Telecom_Customer;


public class Telecom_CustomerDao {
	public static final String JDBC_URL="jdbc:derby:C:\\Users\\2072308\\MyDB;create=true";
	public static final String USERNAME = "test";
	public static final String PASSWORD = "test";
	
	public Connection con=null;
	public ResultSet rs=null;
	
	public boolean registerCustomer(Telecom_Customer customer){
		
		try{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con= DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			
			String insertQuery="insert into TBL_Customer_Telecom values(?,?,?)";
			PreparedStatement ps= con.prepareStatement(insertQuery);
			
			ps.setInt(1, customer.getCustomerId());
			ps.setInt(2, customer.getCallduration());
			ps.setString(3, customer.getDatecall());
			
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
	

}
