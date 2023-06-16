package com.kce.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.kce.bean.BookingDetails;
import com.kce.util.DBUtil;

public class BookingDetailDAO {
private static Scanner sc=new Scanner(System.in);
	
	public static void Customer(BookingDetails b) throws ClassNotFoundException{
		try {
		
			Connection con=DBUtil.getConnection();
			PreparedStatement pstmt=con.prepareStatement("INSERT INTO CUSTOMER VALUES(?,?,?,?,?,?)");
			pstmt.setInt(1,b.getB_id());
			pstmt.setString(2,b.getName());
			pstmt.setString(3, b.getEmail());
			pstmt.setInt(4,b.getNoOfTicket());
			pstmt.setDouble(5, b.getAmount());
			pstmt.setInt(6, b.getPhNo());
			pstmt.executeUpdate();
			
			System.out.println("Data inserted successfully!!");
		}catch(SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	public static void UpdateData() throws ClassNotFoundException{
		try {
		Connection con=DBUtil.getConnection();
		PreparedStatement pstmt=con.prepareStatement("UPDATE CUSTOMER SET noOfTickets=? WHERE name=?");
		System.out.println("Enter the No of Tickets to be updated: ");
		int noOfTickets=sc.nextInt();
		System.out.println("Enter the Customer Name: ");
		String name=sc.next();
		pstmt.setInt(1, noOfTickets);
		pstmt.setString(2,name);
		int rowsAffected=pstmt.executeUpdate();
		if(rowsAffected>0) {
			System.out.println("Data updated successfully!!");
		}
		else {
			System.out.println("No records found for the given Package Id");
		}
	}catch(SQLException e) {
		System.out.println("Error: "+e.getMessage());
	}
}
	
	public static void DeleteRows() throws ClassNotFoundException{
		try {
		Connection con=DBUtil.getConnection();
		PreparedStatement pstmt=con.prepareStatement("TRUNCATE TABLE CUSTOMER");
		pstmt.executeUpdate();
		System.out.println("Records deleted successfully!!");
		}catch(SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	public static void Display() throws ClassNotFoundException{
	try {
		Connection con=DBUtil.getConnection();
		PreparedStatement pstmt=con.prepareStatement("SELECT * FROM CUSTOMER");
		ResultSet rs=pstmt.executeQuery();
		System.out.println("Customer Details:");
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", "B_id","Name","Email","NoOfTicket","Amount","PhNo");
		while(rs.next()) {
			System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDouble(5),rs.getInt(6));
		}
		rs.close();
	}catch(SQLException e) {
		System.out.println("Error: "+e.getMessage());
	}
 }
}
