package com.kce.service;

import com.kce.bean.BookingDetails;

public class Customer extends BookingDetails {

	public Customer(int b_id, String name, String email, int noOfTicket, double amount, int phNo) {
		super(b_id, name, email, noOfTicket, amount, phNo);
	}
}
