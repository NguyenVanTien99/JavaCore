package main;

import java.util.Date;

public class Order {
	private Date date;
	
	

	public Order() {
		super();
	}

	public Order(Date date) {
		super();
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
