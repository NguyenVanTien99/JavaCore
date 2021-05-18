package as_901.entities;

import java.io.Serializable;
import java.util.List;

import as_901.utils.PhoneException;
import as_901.utils.Validator;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String phone;
	private String address;
	private List<Order> listOfOrder;
	
	public Customer() {		
	}
	
	public Customer(String name, String phone, String address, List<Order> listOfOrder) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.listOfOrder = listOfOrder;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) throws PhoneException {
		
		if (Validator.isPhone(phone)) {
			this.phone = phone;
		} else {
			throw new PhoneException("phone is not valid");
		}
		
		
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Order> getListOfOrder() {
		return listOfOrder;
	}

	public void setListOfOrder(List<Order> listOfOrder) {
		this.listOfOrder = listOfOrder;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", phone=" + phone + ", address=" + address + ", listOfOrder=" + listOfOrder
				+ "]";
	}
	
	
	
	
	
	
}
