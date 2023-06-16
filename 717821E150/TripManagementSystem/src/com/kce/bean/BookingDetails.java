package com.kce.bean;

public class BookingDetails {
	private int B_id;
	private String name;
	private String email;
	private int noOfTicket;
	private double amount;
	private int phNo;
	   
    public BookingDetails(int b_id, String name, String email, int noOfTicket, double amount, int phNo) {
		super();
		this.B_id = b_id;
		this.name = name;
		this.email = email;
		this.noOfTicket = noOfTicket;
		this.amount = amount;
		this.phNo = phNo;
	}

	public int getB_id() {
		return B_id;
	}

	public void setB_id(int b_id) {
		B_id = b_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNoOfTicket() {
		return noOfTicket;
	}

	public void setNoOfTicket(int noOfTicket) {
		this.noOfTicket = noOfTicket;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getPhNo() {
		return phNo;
	}

	public void setPhNo(int phNo) {
		this.phNo = phNo;
	}

	@Override
	public String toString() {
		return "BookingDetails [B_id=" + B_id + ", name=" + name + ", email=" + email + ", noOfTicket=" + noOfTicket
				+ ", amount=" + amount + ", phNo=" + phNo + "]";
	}


}