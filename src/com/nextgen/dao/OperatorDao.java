package com.nextgen.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.nextgen.bean.Bill;

public class OperatorDao {

	public static final String JDBC_URL = "jdbc:derby:C:\\Users\\2058126\\MyDB;create=true";
	public static final String USERNAME = "test";
	public static final String PASSWORD = "test";

	public Connection con = null;
	public ResultSet rs = null;

	public List<Bill> getTotalUsage(int customerId, String activationDate) {

		List<Bill> bills = new ArrayList<>();

		LocalDate custActivationDate = LocalDate.parse(activationDate);

		int totalUsage = 0;

		LocalTime time = LocalTime.of(00, 00, 00);

		try {

			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

			String selectQuery = "Select dataUsed, callDuration, dateofCall from tbl_call where customerId = ? order by dateofCall ASC";

			PreparedStatement ps = con.prepareStatement(selectQuery);

			ps.setInt(1, customerId);
			rs = ps.executeQuery();
			int month = 1;

			while (rs.next()) {

				if (custActivationDate.compareTo(rs.getDate("dateofCall").toLocalDate()) < 0) {

					if (month == rs.getDate("dateofCall").toLocalDate().getMonthValue()) {
						totalUsage += rs.getInt("dataUsed");
						time = time.plusHours(rs.getTime("callDuration").getHours());
						time = time.plusMinutes(rs.getTime("callDuration").getMinutes());
						time = time.plusSeconds(rs.getTime("callDuration").getSeconds());
						month = rs.getDate("dateofCall").toLocalDate().getMonthValue();

					} else if (totalUsage != 0) {
						double fee = calculateMonthlyFee(totalUsage);
						Bill bill = new Bill(200, customerId, rs.getDate("dateofCall").toLocalDate().getMonthValue() - 1, fee);
						bills.add(bill);

						totalUsage = rs.getInt("dataUsed");
						time = LocalTime.of(rs.getTime("callDuration").getHours(),
								rs.getTime("callDuration").getMinutes(), rs.getTime("callDuration").getSeconds());
						month = rs.getDate("dateofCall").toLocalDate().getMonthValue();

					} else {
						totalUsage = rs.getInt("dataUsed");
						time = LocalTime.of(rs.getTime("callDuration").getHours(),
								rs.getTime("callDuration").getMinutes(), rs.getTime("callDuration").getSeconds());
						month = rs.getDate("dateofCall").toLocalDate().getMonthValue();
					}
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}

		return bills;

	}

	public boolean generateBill(Bill bill) {

		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

			String insertQuery = " insert into tbl_bill(customerId, month, fee) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertQuery);

			ps.setInt(1, bill.getCustomerId());
			ps.setInt(2, bill.getMonth());
			ps.setDouble(3, bill.getFee());

			int count = ps.executeUpdate();

			if (count > 0) {
				return true;
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}

		}

		return false;
	}

	public double calculateMonthlyFee(int usage) {

		double feePerKB = 2.1012;

		double totalFee = usage * feePerKB;

		return Math.round(totalFee*100.0)/100.0;

	}
}
