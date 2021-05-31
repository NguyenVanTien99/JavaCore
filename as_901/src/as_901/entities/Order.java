package as_901.entities;

import java.io.Serializable;
import java.util.Date;

import as_901.utils.OrderException;
import as_901.utils.Validator;

public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String number;
	private Date date;
	
	public Order() {
		
	}
	
	public Order(String number, Date date) {
		super();
		this.number = number;
		this.date = date;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) throws OrderException{
		if (Validator.isOrderNumber(number)) {
			this.number = number;			
		} else {
			throw new OrderException("Order number has 10 digits");
		}
		
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Order [number=" + number + ", date=" + date + "]";
	}
	
	
	
	
}
