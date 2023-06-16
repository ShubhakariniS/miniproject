package com.kce.bean;

public class TripDetails {
	private int P_id;
    private String P_type;
    private double price;
    private String date;
    private String G_name;
    
	public TripDetails(int p_id, String p_type, double price, String date, String g_name) {
		super();
		P_id = p_id;
		P_type = p_type;
		this.price = price;
		this.date = date;
		G_name = g_name;
	}

	public int getP_id() {
		return P_id;
	}

	public void setP_id(int p_id) {
		P_id = p_id;
	}

	public String getP_type() {
		return P_type;
	}

	public void setP_type(String p_type) {
		P_type = p_type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getG_name() {
		return G_name;
	}

	public void setG_name(String g_name) {
		G_name = g_name;
	}

	@Override
	public String toString() {
		return "TripDetails [P_id=" + P_id + ", P_type=" + P_type + ", price=" + price + ", date=" + date + ", G_name="
				+ G_name + "]";
	}
	
    
    
}