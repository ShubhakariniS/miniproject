package com.kce.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.kce.bean.TripDetails;
import com.kce.util.DBUtil;

class InvalidDateException extends Exception{
	public InvalidDateException(String message) {
		super(message);
	}
}
public class TripDetailsDAO {
	private static Scanner sc=new Scanner(System.in);
	
	public static void InsertData(int a) throws ClassNotFoundException{
		try {
		TripDetails[] arr =new TripDetails[a];
		for(int i=0;i<a;i++) {
			System.out.println("Enter Package Id: ");
			int P_id=sc.nextInt();
			System.out.println("Enter Package Type: ");
			String P_type=sc.next();
			System.out.println("Enter Price of package for a single person: ");
			double price=sc.nextDouble();
			System.out.println("Enter the date (DD/MM/YYYY): ");
			String dateStr=sc.next();
			System.out.println("Enter Guide Name: ");
			String G_name=sc.next();
			
			LocalDate date=validateAndParseDate(dateStr);
			
			arr[i]=new TripDetails(P_id,P_type,price,dateStr,G_name);
		}
		
		Connection con=DBUtil.getConnection();
		PreparedStatement pstmt=con.prepareStatement("INSERT INTO TRIP VALUES(?,?,?,?,?)");
		for(int i=0;i<a;i++) {
		pstmt.setInt(1,arr[i].getP_id());
		pstmt.setString(2,arr[i].getP_type());
		pstmt.setDouble(3, arr[i].getPrice());
		pstmt.setString(4,arr[i].getDate());
		pstmt.setString(5, arr[i].getG_name());
		pstmt.executeUpdate();
	 }
		System.out.println("Data inserted successfully!!");
	}catch(SQLException e) {
		System.out.println(e);
	}catch(InvalidDateException e) {
		System.out.println(e.getMessage());
	}
}
	
	private static LocalDate validateAndParseDate(String dateStr)throws InvalidDateException{
		try {
			return LocalDate.parse(dateStr,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		}
		catch(DateTimeParseException e) {
			throw new InvalidDateException("Invalid date format.Please enter the date in the format DD/MM/YYYY.");
		}
	}
	
	public static void UpdateData() throws ClassNotFoundException{
		try {
		Connection con=DBUtil.getConnection();
		PreparedStatement pstmt=con.prepareStatement("UPDATE TRIP SET G_name=? WHERE P_id=?");
		System.out.println("Enter Package Id: ");
		int P_id=sc.nextInt();
		System.out.println("Enter Guide Name: ");
		String G_name=sc.next();
		pstmt.setInt(1, P_id);
		pstmt.setString(2,G_name);
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
	
	public static void DeleteData() throws ClassNotFoundException{
		try {
		Connection con=DBUtil.getConnection();
		PreparedStatement pstmt=con.prepareStatement("DELETE FROM TRIP WHERE P_id=?");
		System.out.println("Enter Package Id to be deleted: ");
		int P_id=sc.nextInt();
		pstmt.setInt(1, P_id);
		int rowsAffected=pstmt.executeUpdate();
		if(rowsAffected>0) {
			System.out.println("Data deleted successfully!!");
		}
		else {
			System.out.println("No records found for the given Package Id");
		}
	}catch(SQLException e) {
		System.out.println("Error: "+e.getMessage());
	}
}
	
	public static void DeleteTable()throws ClassNotFoundException{
		try {
		Connection con=DBUtil.getConnection();
		PreparedStatement pstmt=con.prepareStatement("DROP TABLE TRIP");
		pstmt.executeUpdate();
		System.out.println("Table deleted successfully!!");
	}catch(SQLException e) {
		System.out.println("Error: "+e.getMessage());
	}
}
	public static void DeleteRows() throws ClassNotFoundException{
		try {
		Connection con=DBUtil.getConnection();
		PreparedStatement pstmt=con.prepareStatement("TRUNCATE TABLE TRIP");
		pstmt.executeUpdate();
		System.out.println("Records deleted successfully!!");
		}catch(SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	public static void Display() throws ClassNotFoundException{
		try {
		Connection con=DBUtil.getConnection();
		PreparedStatement pstmt=con.prepareStatement("SELECT * FROM TRIP");
		ResultSet rs=pstmt.executeQuery();
		
		System.out.println("Trip Details:");
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |%n", "P_id","P_type","Price","Date","G_name");
		while(rs.next()) {
			System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |%n",rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5));
		}
		rs.close();
	}catch(SQLException e) {
		System.out.println("Error: "+e.getMessage());
	}
}

	public static double getPrice(int P_id) throws ClassNotFoundException {
		try {
			Connection con=DBUtil.getConnection();
			PreparedStatement pstmt=con.prepareStatement("SELECT PRICE FROM TRIP WHERE P_ID=?");
			pstmt.setInt(1, P_id);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				double Price=rs.getDouble("priceOfSinglePackage");
				return Price;
			}else {
				throw new IllegalArgumentException("No records found for the given Package Id");
			}
		}catch(SQLException e) {
			throw new IllegalArgumentException("Error: "+e.getMessage(),e);
		}
	}
}
