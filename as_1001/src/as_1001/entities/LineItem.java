package as_1001.entities;

public class LineItem {
	private int orderId;
	private int productId;
	private int quantityId;
	private double price;
	
	public LineItem() {
		super();
	}

	public LineItem(int orderId, int productId, int quantityId, double price) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantityId = quantityId;
		this.price = price;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantityId() {
		return quantityId;
	}
	public void setQuantityId(int quantityId) {
		this.quantityId = quantityId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "LineItem [orderId=" + orderId + ", productId=" + productId + ", quantityId=" + quantityId + ", price="
				+ price + "]";
	}
	
	
	
}
