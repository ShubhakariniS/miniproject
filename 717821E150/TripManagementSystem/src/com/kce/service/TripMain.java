package com.kce.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.kce.Dao.BookingDetailDAO;
import com.kce.Dao.TripDetailsDAO;
import com.kce.bean.BookingDetails;

public class TripMain {
	private static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		System.out.println("If you are an Admin enter 1");
		System.out.println("If you want to book enter 2");
		int press=sc.nextInt();
		while (true) {
			if (press == 1) {
				
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("Enter the choice:");
				System.out.println("1. Insert records");
				System.out.println("2. Update records");
				System.out.println("3. Delete records");
				System.out.println("4. Delete table");
				System.out.println("5. Delete rows");
				System.out.println("6. Display records");
				System.out.println("7. Exit");
				
				int choice = sc.nextInt();
				sc.nextLine();
				
				switch (choice) {
			    case 1:

			     System.out.println("Enter the Number of Records to be inserted:");
			     TripDetailsDAO.InsertData(sc.nextInt());

			     break;

			    case 2:
			     TripDetailsDAO.UpdateData();
			     break;

			    case 3:
			     TripDetailsDAO.DeleteData();
			     break;

			    case 4:
			     TripDetailsDAO.DeleteTable();
			     break;

			    case 5:
				 TripDetailsDAO.DeleteRows();
				 break;
				     
			    case 6:
				 TripDetailsDAO.Display();
				 break;
				     
			    case 7:
			     System.out.println("Thank You!!!!");
			     System.exit(0);
			     break;

			    default:
			     System.out.println("Invalid choice....");
			     break;
			    }

	} else if (press == 2) {
	     while (true) {
			     System.out.println("Enter the Choice");
			     System.out.println("1. Customer: ");
			     System.out.println("2. Delete Rows");
			     System.out.println("3. Update Data");
			     System.out.println("4. Display Customer Details");
			     System.out.println("5. Exit");
			     int choice = sc.nextInt();
			     sc.nextLine();
			     
			     switch (choice) {
			     case 1:
			      TripDetailsDAO.Display();

			      System.out.println("Enter Booking Id: ");
			      int B_id=sc.nextInt();
			      System.out.println("Enter Customer Name: ");
			      String name = sc.next();
			      System.out.println("Enter the Email: ");
			      String email = sc.next();
			      System.out.println("Enter No of Tickets: ");
			      int noOfTicket = sc.nextInt();
			      System.out.println("Enter the Amount: ");
			      double amount = sc.nextDouble();
			      System.out.println("Enter the PhoneNo: ");
			      int phNo=sc.nextInt();

			      double Price = TripDetailsDAO.getPrice(B_id);
			      double totalBill = noOfTicket * Price;

			      System.out.println("Details Collected Successfully!!!");
			      System.out.println("Total Bill: $" + totalBill);

			      BookingDetails bookingDetails = new BookingDetails(B_id,name,email,noOfTicket,amount,phNo);
			      BookingDetailDAO.Customer(bookingDetails);
			      break;
			     case 2:
			      BookingDetailDAO.DeleteRows();
			      break;
			     case 3:
			      BookingDetailDAO.UpdateData();
			      break;
			     case 4:
			      BookingDetailDAO.Display();
			      break;

			     case 5:
			      System.out.println("Thank You!!!!");
			      System.exit(0);
			      break;
			default:

			      System.out.println("Invalid choice....");
			      break;
			     }

			     System.out.println("--------------------------------------------------------------------------------------------------------------------------");

			     
			    }
			   }}}}
