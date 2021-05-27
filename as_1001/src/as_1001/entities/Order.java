package as_1001.entities;

import java.sql.Date;

public class Order {
	private int oderId;
	private String oderDate;
	private int customerId;
	private int employeeId;
	private double total;

	public Order(int oderId, String oderDate, int customerId, int employeeId, double total) {
		super();
		this.oderId = oderId;
		this.oderDate = oderDate;
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.total = total;
	}

	public Order() {
		super();
	}

	public int getOderId() {
		return oderId;
	}

	public void setOderId(int oderId) {
		this.oderId = oderId;
	}

	public String getOderDate() {
		return oderDate;
	}

	public void setOderDate(String oderDate) {
		this.oderDate = oderDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order [oderId=" + oderId + ", oderDate=" + oderDate + ", customerId=" + customerId + ", employeeId="
				+ employeeId + ", total=" + total + "]";
	}
	
	

}
